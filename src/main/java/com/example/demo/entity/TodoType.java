package com.example.demo.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * タスクの重要度詳細を管理するクラス.
 * 
 * @version 1.0.0
 * @author k.ogiwara
 */
@Data
public class TodoType implements Serializable {
	/** シリアルバージョンUID生成 */
	private static final long serialVersionUID = -8130946693797651831L;

	/** タイプID */
	private int typeId;

	/** タスクの重要度 */
	private String type;

	/** 重要度に関するコメント */
	private String comment;
}
