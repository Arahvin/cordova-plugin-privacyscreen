var exec = require('cordova/exec');
 
function PrivacyScreenPlugin() {}
 
PrivacyScreenPlugin.prototype.setStatus = function (enabled, successCallback, errorCallback) {
    exec(successCallback, errorCallback, 'PrivacyScreenPlugin', 'setStatus', [enabled]);
};
 
module.exports = new PrivacyScreenPlugin();