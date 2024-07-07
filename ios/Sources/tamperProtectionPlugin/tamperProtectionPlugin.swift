import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(tamperProtectionPlugin)
public class tamperProtectionPlugin: CAPPlugin, CAPBridgedPlugin {
    public let identifier = "tamperProtectionPlugin"
    public let jsName = "tamperProtection"
    public let pluginMethods: [CAPPluginMethod] = [
        CAPPluginMethod(name: "verifySignatures", returnType: CAPPluginReturnPromise)
    ]
    private let implementation = tamperProtection()

    @objc func verifySignatures(_ call: CAPPluginCall) {
        call.resolve([
            "isSigned": true
        ])
    }
}
