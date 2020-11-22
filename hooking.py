import frida
import sys

def on_message(message, data):
    if message['type'] == 'send':
        print("[*] {0}".format(message['payload']))
    else:
        print(message)

PACKAGE_NAME = "org.techtown.android"

jscode = """
setImmediate(function(){
	Java.perform(function(){
		var exit_bypass = Java.use("java.lang.System");
		exit_bypass.exit.implementation = function(arg){
			console.log("[*] Success");
		}
	})
});
"""

try:
    print('[*] Start!! ')
    device = frida.get_usb_device(timeout=10)
    pid = device.spawn([PACKAGE_NAME])
    process = device.attach(pid)
    device.resume(pid)
    script = process.create_script(jscode)
    print('[*] Running Hook')
    script.load()
    sys.stdin.read()
except Exception as e:
    print(e)