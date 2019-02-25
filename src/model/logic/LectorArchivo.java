package model.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import gramatica.BibtextGrammar;


public class LectorArchivo {

	public final String ARTICLE = "article";
	public final String BOOK= "book";
	public final String BOOKLET = "booklet";
	public final String CONFERENCE = "conference";
	public final String INBOOK = "inbook";
	public final String INCOLLECTION = "incollection";
	public final String INPROCEEDING = "inproceedings";
	public final String MANUAL = "manual";
	public final String MASTERSTHESIS = "mastersthesis";
	public final String MISC= "misc";
	public final String PHDTHESIS = "phdthesis";
	public final String PROCEEDINGS = "proceedings";
	public final String TECHREPORT = "techreport";
	public final String UNPUBLISHED = "unpublished";

	private ArrayList<String> listBibliographies;
	private int successes;
	private int lexicErrors;
	private int sintaxErrors;

	private int totalArticles;
	private int totalBooks;
	private int totalBooklets;
	private int totalConferences;
	private int totalInbooks;
	private int totalIncollections;
	private int totalInproceedings;
	private int totalManuals;
	private int totalMastersThesis;
	private int totalMiscs;
	private int totalPhdThesis;
	private int totalProceedings;
	private int totalTechReports;
	private int totalUnPublished;

	public LectorArchivo() {
		listBibliographies = null;
		successes = 0;
		lexicErrors = 0;
		sintaxErrors = 0;
		
		totalArticles = 0;
		totalBooks = 0;
		totalBooklets = 0;
		totalConferences = 0;
		totalInbooks = 0;
		totalIncollections = 0;
		totalInproceedings = 0;
		totalManuals = 0;
		totalMastersThesis = 0;
		totalMiscs = 0;
		totalPhdThesis = 0;
		totalProceedings = 0;
		totalTechReports = 0;
		totalUnPublished = 0;
		
	}


	public boolean read(String filePath) throws IOException {


		FileReader fileReader = null;
		BufferedReader buffer = null;
		try {
			fileReader= new FileReader(filePath);
			buffer = new BufferedReader(fileReader);

			String line = "";
			String completeFile = "";
			String type = "";

			while( (line = buffer.readLine()) != null) {
				completeFile += line;
				if(line.startsWith("@")) {
					String array[] = line.split("\\{");
					type = array[0].substring(1);
					//System.out.println("TYPE:"+ type);
					countTotalBibliographyTypes(type);
				}
			}

			completeFile = deleteTabs(completeFile);
			completeFile = deleteJumpLine(completeFile);
			//System.out.println(completeFile);

			String[] array = completeFile.split("@");
			this.listBibliographies = new ArrayList<>(Arrays.asList(array));
			if(listBibliographies.get(0).equals("")) {
				listBibliographies.remove(0);	
			}
			for(int i=0; i<listBibliographies.size();i++) {
				listBibliographies.set(i, "@" + listBibliographies.get(i)); 
				System.out.println(listBibliographies.get(i));
			}
			// manipular la lista para encontrar los datos
			countValidBibliographies();
			

			System.out.println("---------------------------------------------------------------------------------------------------");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}finally {
			buffer.close();
			fileReader.close();

		}
		return true;
	}

	private void countValidBibliographies() {
		// TODO Auto-generated method stub
		BibtextGrammar grammar;
		for(String s: this.listBibliographies) {
			grammar = new BibtextGrammar(System.in);
			grammar.ReInit(new java.io.StringReader(s));
			String resp;
			try {
				int val = grammar.one_line();
				resp = new String("Yei " + val + "\n");
				successes++;
				System.out.println(resp);
			}catch(Exception e) {
				resp = new String ("Error de sintaxis: " + e.getMessage());
				System.out.println(resp);
				sintaxErrors++;
			}catch(Error e) {
				resp = new String ("Error Lexico: "+e.getMessage());
				System.out.println(resp);
				lexicErrors++;
			}
		}

		System.out.println("SUCCESSES: " + successes);
		System.out.println("TOTAL: " + this.listBibliographies.size());
	}


	private static String deleteJumpLine(String completeFile) {
		String nuevo = completeFile.replace("\t", "");
		return nuevo;
	}

	private static String deleteTabs(String completeFile) {
		String nuevo = completeFile.replace("\n", ""); 
		return nuevo;
	}

	private void countTotalBibliographyTypes(String type) {
		switch (type) {

		case ARTICLE:
			totalArticles++;
			break;
		case BOOK:
			totalBooks++;
			break;
		case BOOKLET:
			totalBooklets++;
			break;
		case CONFERENCE:
			totalConferences++;
			break;
		case INBOOK:
			totalInbooks++;
			break;
		case INCOLLECTION:
			totalIncollections++;
			break;
		case INPROCEEDING:
			totalInproceedings++;
			break;
		case MANUAL:
			totalManuals++;
			break;
		case MASTERSTHESIS:
			totalMastersThesis++;
			break;
		case MISC:
			totalMiscs++;
			break;
		case PHDTHESIS:
			totalPhdThesis++;
			break;
		case PROCEEDINGS:
			totalProceedings++;
			break;
		case TECHREPORT:
			totalTechReports++;
			break;
		case UNPUBLISHED:
			totalUnPublished++;
			break;

		default:
			break;
		}

		
		

	}


	public void printConteoBibliografias() {
		
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("CONTEO TIPOS DE BIBLIGORAFIAS:");
		System.out.println();
		System.out.println("Total: " + listBibliographies.size());
		System.out.println();
		System.out.println("Articles: "  + totalArticles);
		System.out.println("Books: "  + totalBooks);
		System.out.println("Booklets: "  + totalBooklets);
		System.out.println("Conferences: "  + totalConferences);
		System.out.println("Inbooks: "  + totalInbooks);
		System.out.println("Incollections: "  + totalIncollections);
		System.out.println("Inproceedings: "  + totalInproceedings);
		System.out.println("Manuals: "  + totalManuals);
		System.out.println("Masters Thesis: "  + totalMastersThesis);
		System.out.println("Miscs: "  + totalMiscs);
		System.out.println("Phd Thesis: "  + totalPhdThesis);
		System.out.println("Proceegings: "  + totalProceedings);
		System.out.println("Tech Reports: "  + totalTechReports);
		System.out.println("Unpublished: "  + totalUnPublished);
		System.out.println("---------------------------------------------------------------------------------------------------");
		
	}
	
	public void printValidBibliographies() {
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("BIBLIOGRAFIAS VALIDAS");
		System.out.println();
		System.out.println("De las " + listBibliographies.size() + " bibliografias identificadas,");
		System.out.println();
		System.out.println("\t Validas: " + successes);
		
		System.out.println("---------------------------------------------------------------------------------------------------");
	}


	public void printErrorsData() {
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("DATOS DE ERRORES IDENTIFICADOS EN LAS ENTRADAS BIBLIOGRÁFICAS");
		System.out.println();
		System.out.println("De las " + listBibliographies.size() + " bibliografias identificadas,");
		System.out.println();
		System.out.println("\t Errores léxicos: " + lexicErrors);
		System.out.println("\t Errores de sintáxis: " + sintaxErrors);
		
		System.out.println("---------------------------------------------------------------------------------------------------");
	
		
	}
}