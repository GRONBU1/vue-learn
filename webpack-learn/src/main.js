// 这时main。js 是闷闷项目的js入口文件
// import *** from ***是ES6中导入模块的方式

import $ from "jquery";

$(function() {
  $("li:odd").css("backgroundColor", "lightblue");
  $("li:even").css("backgroundColor", function() {
    return "#" + "D97634";
  });
});
