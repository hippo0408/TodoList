package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Todo;

/**
 * DBへアクセスするためのクラス.
 * 
 * @version 1.0.0
 * @author k.ogiwara
 */
@Mapper
public interface TodoMapper {

	/**
	 * タスク情報一覧取得.
	 * 
	 * @return 取得した未完了タスク情報一覧
	 */
	public List<Todo> getTodoList();

	/**
	 * タスク情報一覧取得.
	 * 
	 * @return 取得した 完了済タスク情報一覧
	 */
	public List<Todo> getTodoDoneList();

	/**
	 * タスク情報一覧取得.
	 * 
	 * @param todo タスク情報
	 */
	public void insertTodoInfo(Todo todo);

	/**
	 * タスクIDを基にタスク情報取得.
	 * 
	 * @param id タスクID
	 * @return タスクIDを基に取得したタスク情報
	 * 
	 */
	public Todo getTodoInfo(int id);

	/**
	 * タスクを完了済に更新.
	 *
	 * @param todo タスク情報
	 */
	public void todoDoneInfo(Todo todo);

	/**
	 * 完了済タスクを未完了に更新.
	 *
	 * @param todo タスク情報
	 */
	public void returnTodoInfo(Todo todo);

	/**
	 * タスク情報更新.
	 *
	 * @param todo タスク情報
	 */
	public void updateTodoInfo(Todo todo);

	/**
	 * タスク情報削除.
	 *
	 * @param todo タスク情報
	 */
	public void deleteTodo(Todo todo);

	/**
	 * タスク情報を全件削除.
	 *
	 * @param todo タスク情報
	 */
	public void deleteAll(Todo todo);
}
