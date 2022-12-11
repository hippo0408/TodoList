package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;

/**
 * タスク情報更新画面を表示するコントローラー.
 * 
 * @version 1.0.0
 * @author k.ogiwara
 */
@Controller
public class TodoUpdateController {

	/** サービスクラスの呼び出し */
	@Autowired
	private TodoService todoService;

	/**
	 * タスク情報更新画面を表示する.
	 *
	 * @param model モデル
	 * @param todo  タスク情報
	 * @param id    タスクID
	 * @return タスク情報更新画面
	 */
	@PostMapping("/todo-detail")
	public String getTodo(Model model, Todo todo, int id) {
		todo = todoService.getId(id);
		model.addAttribute("todo", todo);
		return "update";
	}

	/**
	 * 未完了タスクを完了済み一覧に追加する.
	 *
	 * @param todo               タスク情報
	 * @param redirectAttributes リダイレクト時の情報受け渡し
	 * @return タスク情報一覧画面
	 */
	@PostMapping("/todo-done")
	public String todoDoneInfo(Todo todo, RedirectAttributes redirectAttributes) {
		todoService.todoDone(todo);
		return "redirect:/todo-list";
	}

	/**
	 * 完了済タスクを未完了タスク一覧に追加する.
	 *
	 * @param todo               タスク情報
	 * @param redirectAttributes リダイレクト時の情報受け渡し
	 * @return タスク情報一覧画面
	 */
	@PostMapping("/todo-back")
	public String returnTodoInfo(Todo todo, RedirectAttributes redirectAttributes) {
		todoService.back(todo);
		return "redirect:/todo-list";
	}

	/**
	 * タスクを更新する.
	 *
	 * @param todo               タスク情報
	 * @param bindingResult      バインド結果
	 * @param redirectAttributes リダイレクト時の情報受け渡し
	 * @return バインド結果でエラーが発生した場合、タスク情報更新画面に遷移
	 *         商品情報が更新された場合、商品情報一覧画面に遷移
	 * 
	 */
	@PostMapping("/todo-update")
	public String updateTodoInfo(@ModelAttribute @Valid Todo todo, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "/update";
		}
		todoService.update(todo);
		return "redirect:/todo-list";
	}

	/**
	 * 選択中のタスクを削除する.
	 *
	 * @param todo               タスク情報
	 * @param redirectAttributes リダイレクト時の情報受け渡し
	 * @return タスク情報一覧画面に遷移
	 * 
	 */
	@PostMapping(value = "/todo-delete")
	public String deleteTodo(@ModelAttribute Todo todo, RedirectAttributes redirectAttributes) {
		todoService.deleteTodo(todo);
		return "redirect:/todo-list";
	}

	/**
	 * タスク全件削除する.
	 *
	 * @param todo               タスク情報
	 * @param redirectAttributes リダイレクト時の情報受け渡し
	 * @return タスク情報一覧画面に遷移
	 * 
	 */
	@PostMapping(value = "/delete-all")
	public String deleteAll(@ModelAttribute Todo todo, RedirectAttributes redirectAttributes) {
		todoService.deleteTodoAll(todo);
		return "redirect:/todo-list";
	}
}
