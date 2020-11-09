package com.smartrider.bicycle.vo;

public class UploadFileVo {
	
	private int file_no;
	private int board_no;
	private String file_link;
	
	public UploadFileVo() {
		super();
	}

	public UploadFileVo(int file_no, int board_no, String file_link) {
		super();
		this.file_no = file_no;
		this.board_no = board_no;
		this.file_link = file_link;
	}

	public int getFile_no() {
		return file_no;
	}

	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getFile_link() {
		return file_link;
	}

	public void setFile_link(String file_link) {
		this.file_link = file_link;
	}
	
	
	

}
