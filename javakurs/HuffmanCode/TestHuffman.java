package javakurs.HuffmanCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestHuffman {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("huffman.txt");
		Huffman h = new Huffman();
		System.out.println(h.decode(f));
	}

}
