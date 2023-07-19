/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.managamentsystem.controller;

import ec.edu.espe.managamentsystem.view.FrmPrincipalLogin;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PabloEZurita
 */
public class LoginControllerTest {
    
    public LoginControllerTest() {
    }

    /**
     * Test of principalLogin method, of class LoginController.
     */
    @Test
    public void testPrincipalLogin() {
        System.out.println("principalLogin");
        JTextField txtUsername = null;
        JTextField txtCode = null;
        JLabel lblAlert = null;
        JLabel lblAlert1 = null;
        FrmPrincipalLogin frmPrincipalLogin = null;
        LoginController instance = new LoginController();
        instance.principalLogin(txtUsername, txtCode, lblAlert, lblAlert1, frmPrincipalLogin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class LoginController.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        JTextField usernameField = null;
        JTextField passwordField = null;
        String typeOfUser = "";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.login(usernameField, passwordField, typeOfUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
