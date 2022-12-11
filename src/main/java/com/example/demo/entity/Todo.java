package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * タスク情報を格納するクラス.
 * 
 * @version 1.0.0
 * @author k.ogiwara
 */
@Data
public class Todo implements Serializable {
	/** シリアルバージョンUID生成 */
	private static final long serialVersionUID = -8130946693797651831L;

	/** タスクID */
	private int id;

	/** タスクタイトル */
	@NotBlank
	@Size(min = 1, max = 50)
	private String title;

	/** タスク詳細 */
	@Size(max = 100)
	private String detail;

	/** タスク期限 */
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Future
	@NotNull
	private LocalDateTime deadline;

	/** 完了フラグ */
	private int deleteFlg;

	/** 完了日時 */
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private String doneDate;

	/** タイプID */
	private int typeId;

	/** タスクの重要度 */
	private TodoType todoType;
}
