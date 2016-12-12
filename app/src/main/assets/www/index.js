function showAndroidToast(toast) {
  android.showToast(toast);
}

function saySomething() {
  var out = android.getText(1);
  alert(out);
}

function getWorkers() {
  var out = android.getWorkers();
  alert(out);
}
