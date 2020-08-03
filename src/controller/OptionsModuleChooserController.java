package controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Course;
import model.Delivery;
import model.Module;
import model.StudentProfile;
import view.OptionsModuleChooserRootPane;



public class OptionsModuleChooserController {

	//fields to be used throughout the class
	private OptionsModuleChooserRootPane view;

	private StudentProfile model;

	public OptionsModuleChooserController(OptionsModuleChooserRootPane view, StudentProfile model) {
		//initialise model and view fields
		this.model = model;
		this.view = view;

		//populate combobox in create profile pane, e.g. if profilePane represented your create profile pane you could invoke the line below
		view.getProfilePane().populateComboBoxWithCourses(setupAndRetrieveCourses());

		//attach event handlers to view using private helper method
		this.attachEventHandlers();	

	}

	private void attachEventHandlers() {
		view.getProfilePane().addSubmitEventHandler(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (view.getProfilePane().getSelectedCourse() == null){
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Please Select a Course");
					return;
				}
				if (view.getProfilePane().getPNumber().length() == 0 || 
						view.getProfilePane().getPNumber().charAt(0)!= 'P' || 
						view.getProfilePane().getPNumber().length() != 9 ){
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Please Enter a Valid P Number");
					return;
				}
				if (view.getProfilePane().getForename().length() == 0){
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Please Enter a Valid First Name");
					return;
				}
				if (view.getProfilePane().getSurname().length() == 0){
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Please Enter Youra Valid Last Name");
					return;
				}
				if (view.getProfilePane().getEmailAddress().contains("@") == false || 
						view.getProfilePane().getEmailAddress().contains(".") == false ){
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Please Enter a Valid Email Address");
					return;
				}
				if (view.getProfilePane().getDate() == null || 
						view.getProfilePane().getDate().isBefore(LocalDate.now())){
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Please Enter a Valid Date");
					return;
				}
				model.setCourseOfStudy(view.getProfilePane().getSelectedCourse());
				model.setPnumber(view.getProfilePane().getPNumber());
				model.setStudentName(view.getProfilePane().getName());
				model.setEmail(view.getProfilePane().getEmailAddress());
				model.setSubmissionDate(view.getProfilePane().getDate());
				
				view.getProfilePane().resetPane();
				view.getModulePane().clearComboBoxes();
				view.getModulePane().populateComboBoxesWithModules(model.getCourseOfStudy());
				view.getTabPane().getSelectionModel().select(1);
			}
		});

		view.getModulePane().addSelectorEventHandler1(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (view.getModulePane().getSelectedModuleTerm1() == null) {
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Select a Module!");	
					return;
				}
				Module temp = view.getModulePane().getSelectedModuleTerm1();
				int count = 0;
				for (Module m :view.getModulePane().getSelectedListTerm1()) {
					count = count + m.getCredits();
				}
				if (count + temp.getCredits() > 45) {
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Maximum credits per term is 60.");
					return;
				}
				else {
					view.getModulePane().getSelectedListTerm1().add(view.getModulePane().getSelectedModuleTerm1());
					view.getModulePane().getUnselectedListTerm1().remove(temp);
				}
				view.getModulePane().updateCreditLabels();
			}
		});	
		
		view.getModulePane().addSelectorEventHandler2(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (view.getModulePane().getSelectedModuleTerm2() == null) {
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Select a Module!");	
					return;
				}
				Module temp = view.getModulePane().getSelectedModuleTerm2();
				int count = 0;
				for (Module m :view.getModulePane().getSelectedListTerm2()) {
					count = count + m.getCredits();
				}
				if (count + temp.getCredits() > 45) {
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Maximum credits per term is 60.");
					return;
				}
				else {
					view.getModulePane().getSelectedListTerm2().add(view.getModulePane().getSelectedModuleTerm2());
					view.getModulePane().getUnselectedListTerm2().remove(temp);
				}
				view.getModulePane().updateCreditLabels();
			}
		});	
		
		view.getModulePane().addRemoverEventHandler1(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (view.getModulePane().getRemoveModuleTerm1() == null) {
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Select a Module!");
					return;
				}
				Module temp = view.getModulePane().getRemoveModuleTerm1();
				if (temp.isMandatory() == true) {
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "This module is Mandatory for your course.");		    		
				}
				else {
					view.getModulePane().getUnselectedListTerm1().add(view.getModulePane().getRemoveModuleTerm1());
					view.getModulePane().getSelectedListTerm1().remove(temp);
				}
				view.getModulePane().updateCreditLabels();
			}
		});	

		
		view.getModulePane().addRemoverEventHandler2(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (view.getModulePane().getRemoveModuleTerm2() == null) {
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Select a Module!");
					return;
				}
				Module temp = view.getModulePane().getRemoveModuleTerm2();
				if (temp.isMandatory() == true) {
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "This module is Mandatory for your course.");		    		
				}
				else {
					view.getModulePane().getUnselectedListTerm2().add(view.getModulePane().getRemoveModuleTerm2());
					view.getModulePane().getSelectedListTerm2().remove(temp);
				}
				view.getModulePane().updateCreditLabels();
			}
		});	
		
		view.getModulePane().addSubmitEventHandler(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int count = 30;
				for (Module m : view.getModulePane().getSelectedListTerm1()) {
					count = count + m.getCredits();
				}
				for (Module m : view.getModulePane().getSelectedListTerm2()) {
					count = count + m.getCredits();
				}
				
				if (count != 120) {
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Select modules for 120 credits before you submit.");						
				}
				else {
					model.clearAllSelectedModules();
					for (Module m : view.getModulePane().getSelectedListTerm1()) {
						model.addToSelectedModules(m);
					}
					for (Module m : view.getModulePane().getSelectedListTerm2()) {
						model.addToSelectedModules(m);
					}
					
					populateFinalTab();
					}
					view.getTabPane().getSelectionModel().select(2);
				}
			}
		);	
		
		view.getModulePane().addResetEventHandler(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.getModulePane().clearComboBoxes();
				view.getModulePane().populateComboBoxesWithModules(model.getCourseOfStudy());
			}
		});	
		
		view.getMenu().addExitHandler(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});	
		
		view.getMenu().addHelpHandler(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				alertDialogBuilder(AlertType.INFORMATION, "About", null, "Choose your modules: \nEnter student details \nChoose your modules \nSave overview to file \n(Save progress at any time using the save feature)");
			}
		});	
		
		view.getMenu().addSaveHandler(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StudentProfile.dat"));) {
					oos.writeObject(model);
					oos.flush();
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Student Profile saved to file.");
				}
				catch (IOException ioExcep){
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Error Saving");
					System.out.println(ioExcep);
				}
			}
		});	
		
		view.getMenu().addLoadHandler(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StudentProfile.dat"));) {
					
					model = (StudentProfile) ois.readObject();
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Load Successful");
					view.getModulePane().clearComboBoxes();
					view.getModulePane().populateComboBoxesWithModules(model.getCourseOfStudy());

					if (model.getAllSelectedModules().isEmpty() == false) {
						for (Module m : model.getAllSelectedModules()) {
							if (m.getRunPlan().toString() == "TERM_1" && m.isMandatory() == false) {
								view.getModulePane().getSelectedListTerm1().add(m);
								view.getModulePane().getUnselectedListTerm1().remove(m);
								view.getModulePane().updateCreditLabels();
							}
							if (m.getRunPlan().toString() == "TERM_2" && m.isMandatory() == false) {
								view.getModulePane().getSelectedListTerm2().add(m);
								view.getModulePane().getUnselectedListTerm2().remove(m);
								view.getModulePane().updateCreditLabels();
							}
						}
					}
		        }
		        catch (IOException ioExcep){
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Error Loading");
		        }
				catch (ClassNotFoundException c) {
					alertDialogBuilder(AlertType.INFORMATION, "ALERT", null, "Class Not Found");
		        }	
				populateFinalTab();
				view.getTabPane().getSelectionModel().select(2);
			}
		});	

		
		view.getViewModulePane().addPrintEventHandler(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				File printedFile = new File(model.getPnumber() + "_Printed_Details" + ".txt"); 
			    PrintWriter printWriter;
				try {
					printWriter = new PrintWriter (model.getPnumber() + "_Printed_Details" + ".txt");
					printWriter.println (view.getViewModulePane().getInfoText());
					printWriter.close ();     
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			}
		});
	}

	                
	private Course[] setupAndRetrieveCourses() {
		Module imat3423 = new Module("IMAT3423", "Systems Building: Methods", 15, true, Delivery.TERM_1);
		Module imat3451 = new Module("IMAT3451", "Computing Project", 30, true, Delivery.YEAR_LONG);
		Module ctec3902_SoftEng = new Module("CTEC3902", "Rigorous Systems", 15, true, Delivery.TERM_2);	
		Module ctec3902_CompSci = new Module("CTEC3902", "Rigorous Systems", 15, false, Delivery.TERM_2);
		Module ctec3110 = new Module("CTEC3110", "Secure Web Application Development", 15, false, Delivery.TERM_1);
		Module ctec3426 = new Module("CTEC3426", "Telematics", 15, false, Delivery.TERM_1);
		Module ctec3605 = new Module("CTEC3605", "Multi-service Networks 1", 15, false, Delivery.TERM_1);	
		Module ctec3606 = new Module("CTEC3606", "Multi-service Networks 2", 15, false, Delivery.TERM_2);	
		Module ctec3410 = new Module("CTEC3410", "Web Application Penetration Testing", 15, false, Delivery.TERM_2);
		Module ctec3904 = new Module("CTEC3904", "Functional Software Development", 15, false, Delivery.TERM_2);
		Module ctec3905 = new Module("CTEC3905", "Front-End Web Development", 15, false, Delivery.TERM_2);
		Module ctec3906 = new Module("CTEC3906", "Interaction Design", 15, false, Delivery.TERM_1);
		Module imat3410 = new Module("IMAT3104", "Database Management and Programming", 15, false, Delivery.TERM_2);
		Module imat3406 = new Module("IMAT3406", "Fuzzy Logic and Knowledge Based Systems", 15, false, Delivery.TERM_1);
		Module imat3611 = new Module("IMAT3611", "Popular Technology Ethics", 15, false, Delivery.TERM_1);
		Module imat3613 = new Module("IMAT3613", "Data Mining", 15, false, Delivery.TERM_1);
		Module imat3614 = new Module("IMAT3614", "Big Data and Business Models", 15, false, Delivery.TERM_2);
		Module imat3428_CompSci = new Module("IMAT3428", "Information Technology Services Practice", 15, false, Delivery.TERM_2);

		Course compSci = new Course("Computer Science");
		compSci.addModuleToCourse(imat3423);
		compSci.addModuleToCourse(imat3451);
		compSci.addModuleToCourse(ctec3902_CompSci);
		compSci.addModuleToCourse(ctec3110);
		compSci.addModuleToCourse(ctec3426);
		compSci.addModuleToCourse(ctec3605);
		compSci.addModuleToCourse(ctec3606);
		compSci.addModuleToCourse(ctec3410);
		compSci.addModuleToCourse(ctec3904);
		compSci.addModuleToCourse(ctec3905);
		compSci.addModuleToCourse(ctec3906);
		compSci.addModuleToCourse(imat3410);
		compSci.addModuleToCourse(imat3406);
		compSci.addModuleToCourse(imat3611);
		compSci.addModuleToCourse(imat3613);
		compSci.addModuleToCourse(imat3614);
		compSci.addModuleToCourse(imat3428_CompSci);

		Course softEng = new Course("Software Engineering");
		softEng.addModuleToCourse(imat3423);
		softEng.addModuleToCourse(imat3451);
		softEng.addModuleToCourse(ctec3902_SoftEng);
		softEng.addModuleToCourse(ctec3110);
		softEng.addModuleToCourse(ctec3426);
		softEng.addModuleToCourse(ctec3605);
		softEng.addModuleToCourse(ctec3606);
		softEng.addModuleToCourse(ctec3410);
		softEng.addModuleToCourse(ctec3904);
		softEng.addModuleToCourse(ctec3905);
		softEng.addModuleToCourse(ctec3906);
		softEng.addModuleToCourse(imat3410);
		softEng.addModuleToCourse(imat3406);
		softEng.addModuleToCourse(imat3611);
		softEng.addModuleToCourse(imat3613);
		softEng.addModuleToCourse(imat3614);

		Course[] courses = new Course[2];
		courses[0] = compSci;
		courses[1] = softEng;

		return courses;
	}
	private void alertDialogBuilder(AlertType type, String title, String header, String content) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

	private void populateFinalTab() {
		view.getViewModulePane().setInfoText(
				"\n PNumber: " + model.getPnumber() +
				"\n First Name: " + model.getStudentName().getFirstName() +
				"\n Last Name: " + model.getStudentName().getFamilyName() +
				"\n Email Address: " + model.getEmail() +
				"\n Date: " + model.getSubmissionDate() + "\n\n");
		
		for (Module m : model.getAllSelectedModules()) {
		view.getViewModulePane().setInfoText(view.getViewModulePane().getInfoText() + 
				"\n Module Code: " + m.getModuleCode() + 
				"\n Module Name: " + m.getModuleName() + 
				"\n Credits: " + m.getCredits() + 
				"\n Mandatory?  " + m.isMandatory() + 
				"\n Delivery: " + m.getRunPlan().toString() + "\n");
		
		}
	}
}
