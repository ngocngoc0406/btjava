package ky2lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class lab1bai3quanly  {
	private ArrayList<lab1bai3> studentList;
	private Scanner scanner;

	public lab1bai3quanly() {
		studentList = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	private void deleteStudentInfo(ArrayList<lab1bai3> list, lab1bai3 studentDelete) {

		list.remove(studentDelete);
	}

	public void displayStudentList() {
		System.out.println("Danh sách sinh viên:");
		for (lab1bai3 student : studentList) {
			System.out.println(student.toString());
		}
	}

	public List<lab1bai3> searchStudent(List<lab1bai3> list, String keyword) {
		List<lab1bai3> listSerach = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStudentName().equalsIgnoreCase(keyword)) {
				listSerach.add(list.get(i));
			}
		}
		Collections.sort(listSerach);
		return listSerach;
	}

	public lab1bai3 findStudentById(List<lab1bai3> list, String idStudent) {
		lab1bai3 l = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStudentName().equalsIgnoreCase(idStudent)) {
				l = list.get(i);
			}
		}
		return l;
	}

	public void start() {
		int choice = 0;
		do {
			System.out.println("CHUONG TRINH QUAN LY SINH VIEN:");
			System.out.println("1. Nhap thong tin sinh vien");
			System.out.println("2. Tim và sap xep");
			System.out.println("3. Cap nhat/ xoa");
			System.out.println("4. Xuat thong tin");
			System.out.println("5. Thoat");

			System.out.print("Nhap lua chon cua ban: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				inputStudentInfo();
				break;
			case 2:
				searchAndSort();
				break;
			case 3:
				updateOrDeleteStudentInfo();
				break;
			case 4:
				printStudentInfo();
				break;
			case 5:
				System.out.println("Ket thuc chuong trinh!");
				break;
			default:
				System.out.println("Lua chon khong hop le!");
				break;
			}
		} while (choice != 5);
	}

	private void updateOrDeleteStudentInfo() {
		String s = "“Bạn muốn cập nhật (C) hay xóa (X) ?";
		System.err.println(s);
		String option = scanner.nextLine();
		System.out.println("Nhập id student can thao tac: ");

		String id = scanner.nextLine();
		lab1bai3 student = findStudentById(studentList, id);
		if (student == null) {
			System.err.println("Khong cos id student nay");
		} else {
			if (option.equalsIgnoreCase("x")) {

				deleteStudentInfo(studentList, student);
			}
			if (option.equalsIgnoreCase("c")) {
				for(int i=0; i<studentList.size();i++) {
					if(studentList.get(i).getStudentId().equalsIgnoreCase(id)) {
						System.out.println("Nhap lại ten");
						studentList.get(i).setStudentName(scanner.nextLine());
						System.out.println("Nhap lai subject");
						studentList.get(i).setSubject(scanner.nextLine());
						System.out.println("Nhap lại semetes");
						studentList.get(i).setSemester(scanner.nextInt());
						scanner.nextLine();
						
					}
				}
			}
		}

	}

	private void searchAndSort() {

		int choice = 0;
		do {

			System.out.println("1. Tim kiem");
			System.out.println("2. Sap xep");

			System.out.println("3. Thoat");

			System.out.print("Nhap lua chon cua ban: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Nhap ten can tim: ");
				System.out.println(searchStudent(studentList, scanner.nextLine()).toString());
				break;
			case 2:
				sortByName();
				break;

			case 3:

				break;
			default:
				System.out.println("Lua chon khong hop le!");
				break;
			}
		} while (choice != 3);
	}

	private void sortByName() {
		Collections.sort(studentList);

	}

	private void printStudentInfo() {
		for (lab1bai3 l : studentList) {
			System.out.println(l.toString());
		}

	}

	private void inputStudentInfo() {

		do {
			String studentId, studentName, subject;
			int semester;

			System.out.print("Nhap ma sinh vien: ");
			studentId = scanner.nextLine();

			System.out.print("Nhap ten sinh vien: ");
			studentName = scanner.nextLine();

			System.out.print("Nhap ky hoc: ");
			semester = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Nhap mon hoc: ");
			subject = scanner.nextLine();
			lab1bai3 st = new lab1bai3(studentId, studentName, semester, subject);
			studentList.add(st);
			System.err.println("size: " + studentList.size());
			if (studentList.size() >= 3) {

				String string = "Ban muon tiep tuc (Y/N)? ";
				System.out.println(string);
				String choice = scanner.nextLine();

				do {
					if (choice.equalsIgnoreCase("N")) {
						System.err.println("---------N");
						break;
					} else {
						System.out.print("Nhap ma sinh vien: ");
						String studentId1 = scanner.nextLine();

						System.out.print("Nhap ten sinh vien: ");
						String studentName1 = scanner.nextLine();

						System.out.print("Nhap ky hoc: ");
						int semester1 = scanner.nextInt();
						scanner.nextLine();

						System.out.print("Nhap mon hoc: ");
						String subject1 = scanner.nextLine();

						lab1bai3 student1 = new lab1bai3(studentId1, studentName1, semester1, subject1);
						studentList.add(student1);
					}
				} while (!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N"));
				break;
			}
		} while (true);
	}

	public static void main(String[] args) {
		lab1bai3quanly ql = new lab1bai3quanly();
		ql.start();
	}
}
