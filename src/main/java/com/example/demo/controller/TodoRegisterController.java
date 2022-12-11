package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;

/**
 * タスク登録画面を表示するコントローラー.
 * 
 * @version 1.0.0
 * @author k.ogiwara
 *
 */
@Controller
public class TodoRegisterController {

	/** サービスクラスの呼び出し */
	@Autowired
	private TodoService todoService;

	/**
	 * タスク登録画面を表示する.
	 *
	 * @param todo  タスク情報
	 * @param model モデル
	 * @return 商品情報登録画面
	 */
	@GetMapping("/todo-register")
	public String getRegister(@ModelAttribute Todo todo, Model model) {
		model.addAttribute("todo", todo);
		return "register";
	}

	/**
	 * タスク情報を登録し、一覧画面へ遷移する.
	 *
	 * @param todo               タスク情報
	 * @param bindingResult      バインド結果
	 * @param model              モデル
	 * @param redirectAttributes リダイレクト時の情報受け渡し
	 * @return バインド結果でエラーが発生した場合、タスク登録画面に遷移
	 *         タスク情報が登録された場合、タスク一覧画面に遷移
	 */
	@PostMapping("/todo-register")
	public String postInsert(@ModelAttribute @Valid Todo todo, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "register";
		}
		todoService.insert(todo);
		model.addAttribute("todo", todo);
		return "redirect:/todo-list";
	}
}
