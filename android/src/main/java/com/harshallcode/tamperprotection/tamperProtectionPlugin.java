package com.harshallcode.tamperprotection;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.DialogTitle;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@CapacitorPlugin(name = "tamperProtection")
public class tamperProtectionPlugin extends Plugin {

    @PluginMethod
    public void verifySignatures(PluginCall call) throws NoSuchAlgorithmException, PackageManager.NameNotFoundException {
        JSObject ret = new JSObject();
        String playStoreMd5 = call.getString("playStoreMd5");
        PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), PackageManager.GET_SIGNATURES);

        String[] packagedAppSignatures = new String[packageInfo.signatures.length];

        for (int i = 0; i < packageInfo.signatures.length; i++) {
            Signature signature = packageInfo.signatures[i];
            if (signature == null) continue;

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(signature.toByteArray());
            byte[] digits = md.digest();

            StringBuilder packagedAppSignature = getStringBuilder(digits);
            packagedAppSignatures[i] = packagedAppSignature.toString();
        }
        boolean isSigned;
        isSigned = Objects.equals(playStoreMd5, packagedAppSignatures[0]);

        ret.put("isSigned", isSigned);
        call.resolve(ret);
    }

    private static @NonNull StringBuilder getStringBuilder(byte[] digits) {
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        StringBuilder packagedAppSignature = new StringBuilder();
        for (byte digit : digits) {
            int pos = digit & 0xFF;
            packagedAppSignature.append("").append(hexArray[pos >> 4]).append(hexArray[pos & 0x0f]).append(":");
        }
        if (packagedAppSignature.length() > 0) {
            packagedAppSignature = new StringBuilder(packagedAppSignature.substring(0, packagedAppSignature.length() - 1));
        }
        return packagedAppSignature;
    }
}
