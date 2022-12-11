"use strict";

// タスク表示のタブ切り替え
$(function() {
  $('.tab-target').eq(0).addClass('current');
    $('.tab li').click(function() {
	  var index = $('.tab li').index(this);
	    if ($(this).hasClass('current')) {
		} else {
		  $('.tab li').removeClass('current');
		  $(this).addClass('current');
		  $('.tab-target').removeClass('current');
		  $('.tab-target').eq(index).addClass('current');
		}
	})
});

// 完了済タスクに変更する
$(document).ready(function() {
  $('#btn').on('click', function() {
    $('#form').attr('action', '/todo-done');
      $('#form').submit();
  });
});
function testClick(btn) {
  btn.form.submit();
}

// 未完了タスクに変更する
$(document).ready(function() {
  $('#btn2').on('click', function() {
    $('#form2').attr('action', '/todo-back');
	  $('#form2').submit();
  });
});
function testClick(btn2) {
  btn2.form.submit();
}

// 削除を確認するためのダイアログ
const DELETE_MESSAGE = "タスク情報を削除しますか？"
$('.delete-action').click(function() {
  return confirm(DELETE_MESSAGE);
});
