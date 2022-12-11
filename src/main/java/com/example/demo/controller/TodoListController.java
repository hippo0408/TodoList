package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;

/**
 * タスク一覧画面を表示するコントローラー.
 * 
 * @version 1.0.0
 * @author k.ogiwara
 *
 */
@Controller
public class TodoListController {

	/** サービスクラスの呼び出し */
	@Autowired
	private TodoService todoService;

	/**
	 * タスク一覧画面を表示する.
	 * 
	 * @param model モデル
	 * @return タスク一覧画面
	 */
	@GetMapping("/todo-list")
	public String getTodoList(Model model) {
		List<Todo> todoList = todoService.getList();
		List<Todo> todoDoneList = todoService.getDoneList();
		model.addAttribute("todoList", todoList);
		model.addAttribute("todoDoneList", todoDoneList);
		model.addAttribute("todoListCount", todoList.size());
		model.addAttribute("todoDoneListCount", todoDoneList.size());
		return "todo";
	}
}
