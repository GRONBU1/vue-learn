const path = require("path");

module.exports = {
  // js入口文件
  entry: path.join(__dirname, "./src/main.js"),
  // js出口文件
  output: {
    path: path.join(__dirname, "./dist"),
    filename: "bundle.js"
  }
};
