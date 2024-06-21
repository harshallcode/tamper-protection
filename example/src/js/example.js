import { tamperProtection } from '@harshallcode&#x2F;tamper-protection';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    tamperProtection.echo({ value: inputValue })
}
