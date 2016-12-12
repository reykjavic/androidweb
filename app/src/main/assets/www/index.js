function showAndroidToast(toast) {
  android.showToast(toast);
}

function saySomething() {
  var out = android.getText(1);
  alert(out);
}

function getWorkers() {
  return JSON.parse(android.getWorkers());
}

function loadWorkers() {
  var workers = getWorkers();

  for (var index in workers) {
    $('#workers').append('<li>' + workers[index] + '</li>')
  }
}

