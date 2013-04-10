/*******************************************************************************
 * Copyright (c) 2013 WPI-Suite
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package edu.wpi.cs.wpisuitetng.modules.requirementmanager.view.requirements;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import edu.wpi.cs.wpisuitetng.modules.requirementmanager.models.characteristics.RequirementStatus;
import edu.wpi.cs.wpisuitetng.modules.requirementmanager.models.characteristics.RequirementType;

/**
 * @author Pi 
 * @author Chris
 * @author Brian
 */
abstract public class RequirementPanel extends JScrollPane 
{
	protected JPanel contentPanel;
	protected JPanel leftPanel;
	private JTextField boxName;
	private JTextField boxReleaseNum;
	private JTextArea boxDescription;
	private JTextField boxIteration;
	final protected Border defaultBorder = (new JTextField()).getBorder();
	final protected Border errorBorder = BorderFactory.createLineBorder(Color.RED);
	
	protected JPanel rightPanel;
	private JComboBox dropdownType;
	private JComboBox dropdownStatus;
	private JRadioButton priorityHigh;
	private JRadioButton priorityMedium;
	private JRadioButton priorityLow;
	private JRadioButton priorityBlank;
	private JTextField boxEstimate;
	protected ButtonGroup group;
	
	private JLabel errorName; 
	private JLabel errorDescription;
	private JLabel errorEstimate;	
	
	/**
	 * Builds the left panel.
	 * @return the newly created and formatted left panel.
	 */
	protected JPanel buildLeftPanel()
	{
		leftPanel = new JPanel();
		JLabel labelName = new JLabel("Name *");
		JLabel labelReleaseNum = new JLabel("Release Number");
		JLabel labelDescription = new JLabel("Description *");
		JLabel labelIteration = new JLabel("Iteration");
		
		setBoxName(new JTextField());
		getBoxName().setPreferredSize(new Dimension(200, 20));
		
		boxReleaseNum = (new JTextField());
		getBoxReleaseNum().setPreferredSize(new Dimension(200, 20));
		
		setBoxDescription(new JTextArea());
		getBoxDescription().setLineWrap(true);
		getBoxDescription().setBorder(defaultBorder);
		getBoxDescription().setPreferredSize(new Dimension(200, 200));
		
		setBoxIteration(new JTextField());
		getBoxIteration().setPreferredSize(new Dimension(200, 20));
		
		setErrorName(new JLabel());
		setErrorDescription(new JLabel());

		SpringLayout leftLayout = new SpringLayout();

		leftPanel.setLayout(leftLayout);

		// Name Field
		leftLayout.putConstraint(SpringLayout.NORTH, labelName, 15,
				SpringLayout.NORTH, leftPanel);
		leftLayout.putConstraint(SpringLayout.WEST, labelName, 15,
				SpringLayout.WEST, leftPanel);

		leftLayout.putConstraint(SpringLayout.NORTH, getBoxName(), 15,
				SpringLayout.SOUTH, labelName);
		leftLayout.putConstraint(SpringLayout.WEST, getBoxName(), 15, SpringLayout.WEST,
				leftPanel);
		leftLayout.putConstraint(SpringLayout.NORTH, getErrorName(), 5,
				SpringLayout.SOUTH, getBoxName());
		leftLayout.putConstraint(SpringLayout.WEST, getErrorName(), 15,
				SpringLayout.WEST, leftPanel);
		
		// Release Field
		leftLayout.putConstraint(SpringLayout.NORTH, labelReleaseNum, 15,
				SpringLayout.SOUTH, getErrorName());
		leftLayout.putConstraint(SpringLayout.WEST, labelReleaseNum, 15,
				SpringLayout.WEST, leftPanel);
		leftLayout.putConstraint(SpringLayout.NORTH, getBoxReleaseNum(), 15,
				SpringLayout.SOUTH, labelReleaseNum);
		leftLayout.putConstraint(SpringLayout.WEST, getBoxReleaseNum(), 15,
				SpringLayout.WEST, leftPanel);
		
		
		// Description Field
		leftLayout.putConstraint(SpringLayout.NORTH, labelDescription, 15,
				SpringLayout.SOUTH, getBoxReleaseNum());
		leftLayout.putConstraint(SpringLayout.WEST, labelDescription, 15,
				SpringLayout.WEST, leftPanel);
		leftLayout.putConstraint(SpringLayout.NORTH, getBoxDescription(), 15,
				SpringLayout.SOUTH, labelDescription);
		leftLayout.putConstraint(SpringLayout.WEST, getBoxDescription(), 15,
				SpringLayout.WEST, leftPanel);
		leftLayout.putConstraint(SpringLayout.NORTH, getErrorDescription(), 5,
				SpringLayout.SOUTH, getBoxDescription());
		leftLayout.putConstraint(SpringLayout.WEST, getErrorDescription(), 15,
				SpringLayout.WEST, leftPanel);
		
		// Iteration Field
		leftLayout.putConstraint(SpringLayout.NORTH, labelIteration, 15,
				SpringLayout.SOUTH, getErrorDescription());
		leftLayout.putConstraint(SpringLayout.WEST, labelIteration, 15,
				SpringLayout.WEST, leftPanel);
		leftLayout.putConstraint(SpringLayout.NORTH, getBoxIteration(), 15,
				SpringLayout.SOUTH, labelIteration);
		leftLayout.putConstraint(SpringLayout.WEST, getBoxIteration(), 15,
				SpringLayout.WEST, leftPanel);
		
		
		leftPanel.add(labelName);
		leftPanel.add(getBoxName());
		leftPanel.add(getErrorName());
		
		leftPanel.add(labelReleaseNum);
		leftPanel.add(getBoxReleaseNum());
		
		leftPanel.add(labelDescription);
		leftPanel.add(getBoxDescription());
		leftPanel.add(getErrorDescription());
		
		leftPanel.add(labelIteration);
		leftPanel.add(getBoxIteration());
		
		leftPanel.setMinimumSize(new Dimension(250,500));
		leftPanel.setPreferredSize(new Dimension(250,500));
		
		return leftPanel;
	}
	
	/**
	 * Builds the right panel
	 * @return the newly created and formatted right panel.
	 */
	protected JPanel buildRightPanel()
	{
		rightPanel = new JPanel();

		JLabel labelType = new JLabel("Type");
		JLabel labelStatus = new JLabel("Status");
		JLabel labelPriority = new JLabel("Priority");
		JLabel labelEstimate = new JLabel("Estimate");

		setDropdownType(new JComboBox(RequirementType.values()));
		getDropdownType().setEditable(false);
		
		setDropdownStatus(new JComboBox(RequirementStatus.values()));
		getDropdownStatus().setEditable(false);

		// Radio buttons

		priorityHigh = (new JRadioButton("High"));
		priorityMedium = (new JRadioButton("Medium"));
		priorityLow = (new JRadioButton("Low"));
		priorityBlank = (new JRadioButton("Undecided"));
		getPriorityBlank().setSelected(true);
		
		group = new ButtonGroup();
		group.add(getPriorityBlank());
		group.add(getPriorityHigh());
		group.add(getPriorityMedium());
		group.add(getPriorityLow());
		

		JPanel priorityPanel = new JPanel();
		
		priorityPanel.add(getPriorityLow());
		priorityPanel.add(getPriorityMedium());
		priorityPanel.add(getPriorityHigh());
		priorityPanel.add(getPriorityBlank());

		setBoxEstimate(new JTextField());
		getBoxEstimate().setPreferredSize(new Dimension(200, 20));
		setErrorEstimate(new JLabel());
		
		SpringLayout rightLayout = new SpringLayout();

		rightPanel.setLayout(rightLayout);
 
		//setup the constraints for the layout.
		
		// Type Field
		rightLayout.putConstraint(SpringLayout.NORTH, labelType, 15,
				SpringLayout.NORTH, rightPanel);
		rightLayout.putConstraint(SpringLayout.WEST, labelType, 15,
				SpringLayout.WEST, rightPanel);
		rightLayout.putConstraint(SpringLayout.NORTH, getDropdownType(), 15,
				SpringLayout.SOUTH, labelType);
		rightLayout.putConstraint(SpringLayout.WEST, getDropdownType(), 15,
				SpringLayout.WEST, rightPanel);
		
		// Status Field
		rightLayout.putConstraint(SpringLayout.NORTH, labelStatus, 15,
				SpringLayout.SOUTH, getDropdownType());
		rightLayout.putConstraint(SpringLayout.WEST, labelStatus, 15,
				SpringLayout.WEST, rightPanel);
		rightLayout.putConstraint(SpringLayout.NORTH, getDropdownStatus(), 15,
				SpringLayout.SOUTH, labelStatus);
		rightLayout.putConstraint(SpringLayout.WEST, getDropdownStatus(), 15,
				SpringLayout.WEST, rightPanel);
		
		// Priority Field
		rightLayout.putConstraint(SpringLayout.NORTH, labelPriority, 15,
				SpringLayout.SOUTH, getDropdownStatus());
		rightLayout.putConstraint(SpringLayout.WEST, labelPriority, 15,
				SpringLayout.WEST, rightPanel);
		rightLayout.putConstraint(SpringLayout.NORTH, priorityPanel, 15,
				SpringLayout.SOUTH, labelPriority);
		rightLayout.putConstraint(SpringLayout.WEST, priorityPanel, 15,
				SpringLayout.WEST, rightPanel);

		// Estimate Field
		rightLayout.putConstraint(SpringLayout.NORTH, labelEstimate, 15,
				SpringLayout.SOUTH, priorityPanel);
		rightLayout.putConstraint(SpringLayout.WEST, labelEstimate, 15,
				SpringLayout.WEST, rightPanel);
		rightLayout.putConstraint(SpringLayout.NORTH, getBoxEstimate(), 15,
				SpringLayout.SOUTH, labelEstimate);
		rightLayout.putConstraint(SpringLayout.WEST, getBoxEstimate(), 15,
				SpringLayout.WEST, rightPanel);
		rightLayout.putConstraint(SpringLayout.NORTH, getErrorEstimate(), 5,
				SpringLayout.SOUTH, getBoxEstimate());
		rightLayout.putConstraint(SpringLayout.WEST, getErrorEstimate(), 15,
				SpringLayout.WEST, rightPanel);

		rightPanel.add(labelType);
		rightPanel.add(getDropdownType());
		rightPanel.add(labelStatus);
		rightPanel.add(getDropdownStatus());
		rightPanel.add(labelPriority);
		rightPanel.add(priorityPanel);
		rightPanel.add(labelEstimate);
		rightPanel.add(getBoxEstimate());
		rightPanel.add(getErrorEstimate());
		
		//restrict size of these elements .
		rightPanel.setMinimumSize(new Dimension(315,500));
		rightPanel.setPreferredSize(new Dimension(315,500));
		
		return rightPanel;
	}
	
	/**
	 * Validates the values of the fields in the requirement panel to ensure they are valid
	 */
	public boolean validateFields()
	{
		boolean isNameValid;
		boolean isDescriptionValid;
		boolean isEstimateValid;
		
		if (getBoxName().getText().length() >= 100)
		{
			isNameValid = false;
			getErrorName().setText("No more than 100 chars");
			getBoxName().setBorder(errorBorder);
			getErrorName().setForeground(Color.RED);
		}
		else if(getBoxName().getText().trim().length() <= 0)
		{
			isNameValid = false;
			getErrorName().setText("** Name is REQUIRED");
			getBoxName().setBorder(errorBorder);
			getErrorName().setForeground(Color.RED);
		}
		else
		{
			getErrorName().setText("");
			getBoxName().setBorder(defaultBorder);
			isNameValid = true;
			
		}
		if (getBoxDescription().getText().trim().length() <= 0)
		{
			isDescriptionValid = false;
			getErrorDescription().setText("** Description is REQUIRED");
			getErrorDescription().setForeground(Color.RED);
			getBoxDescription().setBorder(errorBorder);
		}
		else
		{	
			getErrorDescription().setText("");
			getBoxDescription().setBorder(defaultBorder);
			isDescriptionValid = true;
		}
		
		if (getBoxEstimate().getText().trim().length() <= 0)
		{
			getBoxEstimate().setText("");
			getErrorEstimate().setText("");
			getBoxEstimate().setBorder(defaultBorder);
			isEstimateValid = true;
		}
		else if(!(isInteger(getBoxEstimate().getText())))
		{
			getErrorEstimate().setText("** Please enter a non-negative integer");
			getBoxEstimate().setBorder(errorBorder);
			getBoxEstimate().setBorder((new JTextField()).getBorder());

			isEstimateValid = false;
			getErrorEstimate().setForeground(Color.RED);
		}
		else if(Integer.parseInt(getBoxEstimate().getText())<0)
		{
			getErrorEstimate().setText("** Please enter a non-negative integer");
			getBoxEstimate().setBorder(errorBorder);
			isEstimateValid = false;
			getErrorEstimate().setForeground(Color.RED);
		}
		else
		{
			getErrorEstimate().setText("");
			getBoxEstimate().setBorder(defaultBorder);
			isEstimateValid = true;
		}
		
		return isNameValid && isDescriptionValid && isEstimateValid;
	}
	
	/**
	 * Checks if the input string is an integer
	 * @param input the string to test
	 * @return true if input is an integer, false otherwise
	 */
	public boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}

	/**
	 * @return the dropdownStatus
	 */
	public JComboBox getDropdownStatus() {
		return dropdownStatus;
	}

	/**
	 * @param dropdownStatus the dropdownStatus to set
	 */
	public void setDropdownStatus(JComboBox dropdownStatus) {
		this.dropdownStatus = dropdownStatus;
	}

	/**
	 * @return the dropdownType
	 */
	public JComboBox getDropdownType() {
		return dropdownType;
	}

	/**
	 * @param dropdownType the dropdownType to set
	 */
	public void setDropdownType(JComboBox dropdownType) {
		this.dropdownType = dropdownType;
	}

	/**
	 * @return the boxEstimate
	 */
	public JTextField getBoxEstimate() {
		return boxEstimate;
	}

	/**
	 * @param boxEstimate the boxEstimate to set
	 */
	public void setBoxEstimate(JTextField boxEstimate) {
		this.boxEstimate = boxEstimate;
	}

	/**
	 * @return the boxDescription
	 */
	public JTextArea getBoxDescription() {
		return boxDescription;
	}

	/**
	 * @param boxDescription the boxDescription to set
	 */
	public void setBoxDescription(JTextArea boxDescription) {
		this.boxDescription = boxDescription;
	}

	/**
	 * @return the errorEstimate
	 */
	public JLabel getErrorEstimate() {
		return errorEstimate;
	}

	/**
	 * @param errorEstimate the errorEstimate to set
	 */
	public void setErrorEstimate(JLabel errorEstimate) {
		this.errorEstimate = errorEstimate;
	}

	/**
	 * @return the errorName
	 */
	public JLabel getErrorName() {
		return errorName;
	}

	/**
	 * @param errorName the errorName to set
	 */
	public void setErrorName(JLabel errorName) {
		this.errorName = errorName;
	}

	/**
	 * @return the errorDescription
	 */
	public JLabel getErrorDescription() {
		return errorDescription;
	}

	/**
	 * @param errorDescription the errorDescription to set
	 */
	public void setErrorDescription(JLabel errorDescription) {
		this.errorDescription = errorDescription;
	}

	/**
	 * @return the boxIteration
	 */
	public JTextField getBoxIteration() {
		return boxIteration;
	}

	/**
	 * @param boxIteration the boxIteration to set
	 */
	public void setBoxIteration(JTextField boxIteration) {
		this.boxIteration = boxIteration;
	}

	/**
	 * @return the boxName
	 */
	public JTextField getBoxName() {
		return boxName;
	}

	/**
	 * @param boxName the boxName to set
	 */
	public void setBoxName(JTextField boxName) {
		this.boxName = boxName;
	}

	public JRadioButton getPriorityHigh() {
		return priorityHigh;
	}



	public JRadioButton getPriorityMedium() {
		return priorityMedium;
	}

	public JRadioButton getPriorityLow() {
		return priorityLow;
	}

	public JRadioButton getPriorityBlank() {
		return priorityBlank;
	}

	public JTextField getBoxReleaseNum() {
		return boxReleaseNum;
	}


}
