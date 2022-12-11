package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoMapper;

/**
 * DBの実行結果を取得するクラス.
 * 
 * @version 1.0.0
 * @author k.ogiwara
 */
@Service
public class TodoService {

	/** DBにアクセスするマッパー */
	@Autowired
	private TodoMapper todoMapper;

	/**
	 * 未完了タスク情報一覧取得.
	 * 
	 * @return 取得した未完了タスク情報一覧.
	 */
	public List<Todo> getList() {
		return todoMapper.getTodoList();
	}

	/**
	 * 完了済タスク情報一覧取得.
	 * 
	 * @return 取得した完了済タスク情報一覧.
	 */
	public List<Todo> getDoneList() {
		return todoMapper.getTodoDoneList();
	}

	/**
	 * タスク情報登録.
	 * 
	 * @param todo タスク情報
	 */
	@Transactional
	public void insert(Todo todo) {
		todoMapper.insertTodoInfo(todo);
	}

	/**
	 * タスクIDを基にタスク情報取得.
	 * 
	 * @param id タスクID
	 * @return タスクIDを基に取得したタスク情報.
	 */
	public Todo getId(int id) {
		return todoMapper.getTodoInfo(id);
	}

	/**
	 * タスクを完了済に更新.
	 *
	 * @param todo タスク情報
	 */
	@Transactional
	public void todoDone(Todo todo) {
		todoMapper.todoDoneInfo(todo);
	}

	/**
	 * 完了済タスクを未完了に更新.
	 *
	 * @param todo タスク情報
	 */
	@Transactional
	public void back(Todo todo) {
		todoMapper.returnTodoInfo(todo);
	}

	/**
	 * タスク情報更新.
	 *
	 * @param todo タスク情報
	 */
	@Transactional
	public void update(Todo todo) {
		todoMapper.updateTodoInfo(todo);
	}

	/**
	 * タスク情報削除.
	 *
	 * @param todo タスク情報
	 */
	@Transactional
	public void deleteTodo(Todo todo) {
		todoMapper.deleteTodo(todo);
	}

	/**
	 * タスク情報を全件削除.
	 *
	 * @param todo タスク情報
	 */
	@Transactional
	public void deleteTodoAll(Todo todo) {
		todoMapper.deleteAll(todo);
	}
}
