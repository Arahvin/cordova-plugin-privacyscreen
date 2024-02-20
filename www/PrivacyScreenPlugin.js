var exec = require('cordova/exec');

PrivacyScreenPlugin.prototype.setPrivacyScreenEnabled = function (enabled, successCallback, errorCallback) {
    exec(successCallback, errorCallback, 'PrivacyScreenPlugin', 'setPrivacyScreenEnabled', [enabled]);
};

module.exports = new PrivacyScreenPlugin();
