var url = phantom.args[0];

if (!url) {
  console.log('Expected a target URL parameter.');
  phantom.exit(1);
}

var page = require('webpage').create();

page.onConsoleMessage = function(message) {
  console.log(message);
};

console.log("Loading URL: " + url);

page.open(url, function(status) {
  if (status !== "success") {
    console.log('Failed to open ' + url);
    phantom.exit(1);
  } else {
    phantom.exit(0);
  }
});
