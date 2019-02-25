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
import model.world.Article;
import model.world.Bibliography;
import model.world.Book;
import model.world.Booklet;
import model.world.Conference;
import model.world.Inbook;
import model.world.Incollection;
import model.world.Inproceedings;
import model.world.Manual;
import model.world.MastersThesis;
import model.world.Misc;
import model.world.PhdThesis;
import model.world.Proceedings;
import model.world.TechReport;
import model.world.Unpublished;


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
	private ArrayList<String> listBibliographiesWithTabs;
	private int successes;
	private int lexicErrors;
	private int sintaxErrors;
	
	private ArrayList<Bibliography> bibliographiesInfo;
	
	private char[] errorPerEntryInfo;

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
	private String requiredAndOptionalAnalysis;

	public LectorArchivo() {
		listBibliographies = null;
		listBibliographiesWithTabs = null;
		bibliographiesInfo = new ArrayList<Bibliography>();
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
		
		requiredAndOptionalAnalysis = "";
		
	}


	public boolean read(String filePath) throws IOException {


		FileReader fileReader = null;
		BufferedReader buffer = null;
		try {
			fileReader= new FileReader(filePath);
			buffer = new BufferedReader(fileReader);

			String line = "";
			String completeFile = "";
			String completeFileBackup = "";
			String type = "";

			while( (line = buffer.readLine()) != null) {
				completeFile += line;
				completeFileBackup += (line + "\n"); 
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
				//System.out.println(listBibliographies.get(i));
			}
			// manipular la lista para encontrar los datos
			countValidBibliographies();
			
			
			// aca manipulo lo que sera utilizado para analizar campos requeridos y opcionales
			array = completeFileBackup.split("@");
			this.listBibliographiesWithTabs = new ArrayList<>(Arrays.asList(array));
			if(listBibliographiesWithTabs.get(0).equals("")) {
				listBibliographiesWithTabs.remove(0);	
			}
			for(int i=0; i<listBibliographiesWithTabs.size();i++) {
				listBibliographiesWithTabs.set(i, "@" + listBibliographiesWithTabs.get(i)); 
			}

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
		BibtextGrammar grammar;
		int i = 0;
		
		// declaro el arreglo que mapeara la información sobre los tipos de error de cada entrada
		this.errorPerEntryInfo = new char[this.listBibliographies.size()]; 
		
		for(String s: this.listBibliographies) {
			grammar = new BibtextGrammar(System.in);
			grammar.ReInit(new java.io.StringReader(s));
			String resp;
			try {
				int val = grammar.one_line();
				resp = new String("Yei " + val + "\n");
				successes++;
				errorPerEntryInfo[i] = '0'; // 0 para ningun error
				System.out.println(resp);
			}catch(Exception e) {
				resp = new String ("Error de sintaxis: " + e.getMessage());
				System.out.println(resp);
				sintaxErrors++;
				errorPerEntryInfo[i] = 's'; // s para error de sintaxis
			}catch(Error e) {
				resp = new String ("Error Lexico: "+e.getMessage());
				System.out.println(resp);
				System.out.println();
				lexicErrors++;
				errorPerEntryInfo[i] = 'l'; // l para error léxico
			}
			i++;
		}

		System.out.println("SUCCESSES: " + successes);
		System.out.println("TOTAL: " + this.listBibliographies.size());
	}


	private static String deleteJumpLine(String completeFile) {
		String nuevo = completeFile.replace("\n", "");
		return nuevo;
	}

	private static String deleteTabs(String completeFile) {
		String nuevo = completeFile.replace("\t", " "); 
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

	private void checkRequiredAndOptional() {
		String array[];
		String info = "";
		System.out.println("TAMAÑO LISTA:" + listBibliographiesWithTabs.size());
		for(String s:this.listBibliographiesWithTabs) {
			array = s.split("\n");
			System.out.println("S: "+s);
			ArrayList<String> lineas = new ArrayList<>(Arrays.asList(array));
			System.out.println("TAMAÑO LISTA LINEASSSS:" + lineas.size());
			String[] aux = lineas.get(0).split("\\{");
			String type = aux[0].substring(1); // agarro el tipo de bibliografia que es
			lineas.remove(0); // remuevo la linea que tiene el @ y el id
			
			info = "";
			for (String string : lineas) {
				info += string;
			}
			System.out.println("INFO: "+ info);
			switch (type) {

			case ARTICLE:

				Article article = new Article(info);
				bibliographiesInfo.add(article);
				article.checkFields();
				article.buildCheckFieldString();
				requiredAndOptionalAnalysis += article.getFieldCheckInfo();

				
				
				break;

			case BOOK:
				Book book = new Book(info);
				bibliographiesInfo.add(book);
				book.checkFields();
				book.buildCheckFieldString();
				requiredAndOptionalAnalysis += book.getFieldCheckInfo();


				break;

			case BOOKLET:

				Booklet booklet = new Booklet(info);
				bibliographiesInfo.add(booklet);
				booklet.checkFields();
				booklet.buildCheckFieldString();
				requiredAndOptionalAnalysis += booklet.getFieldCheckInfo();

				break;

			case CONFERENCE:

				Conference conference = new Conference(info);
				bibliographiesInfo.add(conference);
				conference.checkFields();
				conference.buildCheckFieldString();
				requiredAndOptionalAnalysis += conference.getFieldCheckInfo();

				break;
			case INBOOK:

				Inbook inbook = new Inbook(info);
				bibliographiesInfo.add(inbook);
				inbook.checkFields();
				inbook.buildCheckFieldString();
				requiredAndOptionalAnalysis += inbook.getFieldCheckInfo();

				break;
			case INCOLLECTION:

				Incollection incollection = new Incollection(info);
				bibliographiesInfo.add(incollection);
				incollection.checkFields();
				incollection.buildCheckFieldString();
				requiredAndOptionalAnalysis += incollection.getFieldCheckInfo();

				break;
			case INPROCEEDING:

				Inproceedings inproceeding = new Inproceedings(info);
				bibliographiesInfo.add(inproceeding);
				inproceeding.checkFields();
				inproceeding.buildCheckFieldString();
				requiredAndOptionalAnalysis += inproceeding.getFieldCheckInfo();

				break;

			case MANUAL:

				Manual manual= new Manual(info);
				bibliographiesInfo.add(manual);
				manual.checkFields();
				manual.buildCheckFieldString();
				requiredAndOptionalAnalysis += manual.getFieldCheckInfo();

				break;
			case MASTERSTHESIS:

				MastersThesis masters = new MastersThesis(info);
				bibliographiesInfo.add(masters);
				masters.checkFields();
				masters.buildCheckFieldString();
				requiredAndOptionalAnalysis += masters.getFieldCheckInfo();

				break;
			case MISC:

				Misc misc = new Misc(info);
				bibliographiesInfo.add(misc);
				misc.checkFields();
				misc.buildCheckFieldString();
				requiredAndOptionalAnalysis += misc.getFieldCheckInfo();

				break;
			case PHDTHESIS:

				PhdThesis phd = new PhdThesis(info);
				bibliographiesInfo.add(phd);
				phd.checkFields();
				phd.buildCheckFieldString();
				requiredAndOptionalAnalysis += phd.getFieldCheckInfo();

				break;
			case PROCEEDINGS:

				Proceedings proceedings= new Proceedings(info);
				bibliographiesInfo.add(proceedings);
				proceedings.checkFields();
				proceedings.buildCheckFieldString();
				requiredAndOptionalAnalysis += proceedings.getFieldCheckInfo();

				break;
			case TECHREPORT:

				TechReport techReport= new TechReport(info);
				bibliographiesInfo.add(techReport);
				techReport.checkFields();
				techReport.buildCheckFieldString();
				requiredAndOptionalAnalysis += techReport.getFieldCheckInfo();

				break;
			case UNPUBLISHED:

				Unpublished unpublished = new Unpublished(info);
				bibliographiesInfo.add(unpublished);
				unpublished.checkFields();
				unpublished.buildCheckFieldString();
				requiredAndOptionalAnalysis += unpublished.getFieldCheckInfo();

				break;

			default:
				break;
			}
			
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
	
	public void printRequiredAndOptionalAnalysis() {
		this.checkRequiredAndOptional();
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println(this.requiredAndOptionalAnalysis);
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println();
	}


	public void printErrorsPerEntry() {
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("TIPOS DE ERROR IDENTIFICADOS POR ENTRADA (Java CC): ");
		System.out.println();
		for(int i=0; i<this.errorPerEntryInfo.length;i++) {
			if(errorPerEntryInfo[i] == '0') {
				System.out.println("# " + (i+1) + ": " + "N/A");
			}else if(errorPerEntryInfo[i] == 's') {
				System.out.println("# " + (i+1) + ": " + "Error de sintáxis");
			}else if(errorPerEntryInfo[i] == 'l') {
				System.out.println("# " + (i+1) + ": " + "Error léxico");
			}
		}
		System.out.println("---------------------------------------------------------------------------------------------------");
		
	}
}