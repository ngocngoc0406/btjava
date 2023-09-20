/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

/**
 *
 * @author HP
 */
import javax.swing.ImageIcon;

public class MyModel {
	private int x = 15;
	private int y = 15 ;
	int[][] matran = new int [x][y];
	public void initMatran() {
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++) {
				matran[i][j] = 0;
			}
	}
	public int checkHang() {
		int win = 0, hang = 0, n = 0, k = 0;
		boolean check = false;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (check) {
					if (matran[i][j] == 1) {
						hang++;
						if (hang > 4) {
							win = 1;
							break;
						}
						continue;
					} else {
						check = false;
						hang = 0;
					}
				}
				if (matran[i][j] == 1) {
					check = true;
					hang++;
				} else {
					check = false;
				}
			}
			hang = 0;
		}
		return win;
	}

	public int checkCot() {
		int win = 0, cot = 0;
		boolean check = false;
		for (int j = 0; j < y; j++) {
			for (int i = 0; i < x; i++) {
				if (check) {
					if (matran[i][j] == 1) {
						cot++;
						if (cot > 4) {
							win = 1;
							break;
						}
						continue;
					} else {
						check = false;
						cot = 0;
					}
				}
				if (matran[i][j] == 1) {
					check = true;
					cot++;
				} else {
					check = false;
				}
			}
			cot = 0;
		}
		return win;
	}

	public int checkCheoPhai() {
		int win = 0, cheop = 0, n = 0, k = 0;
		boolean check = false;
		for (int i = x - 1; i >= 0; i--) {
			for (int j = 0; j < y; j++) {
				if (check) {
					if (matran[n - j][j] == 1) {
						cheop++;
						if (cheop > 4) {
							win = 1;
							break;
						}
						continue;
					} else {
						check = false;
						cheop = 0;
					}
				}
				if (matran[i][j] == 1) {
					n = i + j;
					check = true;
					cheop++;
				} else {
					check = false;
				}
			}
			cheop = 0;
			check = false;
		}
		return win;
	}

	public int checkCheoTrai() {
		int win = 0, cheot = 0, n = 0;
		boolean check = false;
		for (int i = 0; i < x; i++) {
			for (int j = y - 1; j >= 0; j--) {
				if (check) {
					if (matran[n - j - 2 * cheot][j] == 1) {
						cheot++;
						System.out.print("+" + j);
						if (cheot > 4) {
							win = 1;
							break;
						}
						continue;
					} else {
						check = false;
						cheot = 0;
					}
				}
				if (matran[i][j] == 1) {
					n = i + j;
					check = true;
					cheot++;
				} else {
					check = false;
				}
			}
			n = 0;
			cheot = 0;
			check = false;
		}
		return win;
	}
	public int getRows() {
		return x;
	}

	public int getCols() {
		return y;
	} 
	
}
