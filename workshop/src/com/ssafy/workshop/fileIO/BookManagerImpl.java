package com.ssafy.workshop.fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager {
	private List<Book> books;
	private static IBookManager instance;

	private BookManagerImpl() {
		loadData(); // file로 저장할 것이기 때문에 생성자로 List를 만들 필요가 없다.
	}

	public static IBookManager getInstance() {
		if (instance == null)
			instance = new BookManagerImpl();
		return instance;
	}

	public int findIndex(String isbn) {
		if (isbn != null) {
			for (int i = 0, size = books.size(); i < size; i++) {
				if (isbn.equals(books.get(i).getIsbn()))
					return i;
			}
		}
		return -1;
	}

	@Override
	public void add(Book book) {
		if (book != null) {
			String isbn = book.getIsbn();
			int index = findIndex(isbn);
			if (index > -1)
				throw new BookException("이미 존재하는 책 번호입니다. 다시 입력해주세요");
			books.add(book);
		} else
			throw new BookException("책 정보를 다시 입력해주세요");

	}

	@Override
	public void remove(String isbn) {
		if (isbn != null) {
			int index = findIndex(isbn);
			if (index == -1)
				throw new ISBNNotFoundException(isbn);
			books.remove(index);
		} else
			throw new BookException("책 번호를 다시 입력해주세요");
	}

	@Override
	public Book[] getList() {
		Book[] b = new Book[books.size()];
		books.toArray(b);
		return b;
	}

	@Override
	public Book searchByIsbn(String isbn) {
		if (isbn != null) {
			int index = findIndex(isbn);
			if (index == -1)
				throw new ISBNNotFoundException(isbn);
			return books.get(index);
		} else
			throw new BookException("책 번호를 다시 입력해주세요");
	}

	@Override
	public Book[] searchByTitle(String title) {
		int count = 0;
		int index = 0;
		for (int i = 0, size = books.size(); i < size; i++) {
			if (books.get(i).getTitle().contains(title))
				count++;
		}
		Book[] b = new Book[count];
		for (int i = 0, size = books.size(); i < size; i++) {
			if (books.get(i).getTitle().contains(title)) {
				b[index++] = books.get(i);
			}
		}
		return b;
	}

	@Override
	public Magazine[] getMagazines() {
		int count = 0;
		int index = 0;
		for (int i = 0, size = books.size(); i < size; i++) {
			if (books.get(i) instanceof Magazine)
				count++;
		}
		Magazine[] m = new Magazine[count];
		for (int i = 0, size = books.size(); i < size; i++) {
			if (books.get(i) instanceof Magazine) {
				m[index++] = (Magazine) books.get(i);
			}
		}
		return m;
	}

	@Override
	public Book[] getBooks() {
		int count = 0;
		int index = 0;
		for (int i = 0, size = books.size(); i < size; i++) {
			if (!(books.get(i) instanceof Magazine))
				count++;
		}
		Book[] b = new Book[count];
		for (int i = 0, size = books.size(); i < size; i++) {
			if (!(books.get(i) instanceof Magazine)) {
				b[index++] = books.get(i);
			}
		}
		return b;
	}

	@Override
	public int getTotalPrice() {
		int sum = 0;
		for (int i = 0, size = books.size(); i < size; i++) {
			sum += books.get(i).getQuantity() * books.get(i).getPrice();
		}
		return sum;
	}

	@Override
	public double getPriceAvg() {
		int sum = 0;
		for (int i = 0, size = books.size(); i < size; i++) {
			sum += books.get(i).getQuantity() * books.get(i).getPrice();
		}
		return (double) sum / books.size();
	}

	@Override
	public void sell(String isbn, int quantity) {
		if (isbn != null) {
			int index = findIndex(isbn);
			if (index == -1)
				throw new ISBNNotFoundException(isbn);
			int stuck = books.get(index).getQuantity();
			if (quantity > stuck)
				throw new QuantityException("재고가 부족합니다. 팔 수 없습니다.");
			stuck -= quantity;
			books.get(index).setQuantity(stuck);
		}

	}

	@Override
	public void buy(String isbn, int quantity) {
		if (isbn != null) {
			int index = findIndex(isbn);
			if (index == -1)
				throw new ISBNNotFoundException(isbn);
			int stuck = books.get(index).getQuantity();
			stuck += quantity;
			books.get(index).setQuantity(stuck);
		}

	}

	@Override
	public void saveData() {
		{
			try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("book.dat")))) {
				for (Book book : books) {
					out.write(book.toString());
					out.newLine();
				}
			} catch (Exception e) {
				System.out.println("[SYSTEM] 파일 쓰기 실패");
				e.printStackTrace();
			}
		}
	}

	private void loadData() {
		File file = new File("book.dat");
		books = new ArrayList<Book>(); // load할 때 리스트를 만들어 주어야 한다.
		if (file.exists()) {
			try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
				String line = null;
				while ((line = in.readLine()) != null) {
					String[] info = line.split(",");
					if(info.length == 7) {
					books.add(new Book(info[0].trim()
							, info[1].trim()
							, info[2].trim()
							, info[3].trim()
							, Integer.parseInt(info[4].trim())
							, info[5].trim()
							, Integer.parseInt(info[6].trim())
							));
					}else {
						books.add(new Magazine(info[0].trim()
								, info[1].trim()
								, info[2].trim()
								, info[3].trim()
								, Integer.parseInt(info[4].trim())
								, info[5].trim()
								, Integer.parseInt(info[6].trim())
								, Integer.parseInt(info[7].trim())
								,Integer.parseInt(info[8].trim())
								));
					}
				}
			} catch (Exception e) {
				System.out.println("[SYSTEM]파일 읽기에 실패했습니다.");
				e.printStackTrace();
			}
		}
	}

}
