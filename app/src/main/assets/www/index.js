function showAndroidToast(toast) {
  android.showToast(toast);
}

function saySomething() {
  var out = android.getText(1);
  alert(out);
}
