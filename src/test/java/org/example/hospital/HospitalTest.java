package org.example.hospital;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class HospitalTest {

    private Hospital hospital;

    @BeforeEach
    void setupHospital(){
        hospital = new Hospital(3);
        Patient pat1 = new Patient("pat1");
        Patient pat2 = new Patient("pat2");
        Patient pat3 = new Patient("pat3");
        hospital.add(pat1);
        hospital.add(pat2);
        hospital.add(pat3);
    }


    @Test
    void addPatientTest() {
        Hospital hospital = new Hospital(30);
        Patient pat1 = new Patient("pat1");
        assertTrue(hospital.add(pat1));
    }

    @Test
    void addTowPatientsOneBed(){
        Hospital hospital = new Hospital(1);
        Patient patient = new Patient("1");
        Patient patient2 = new Patient("2");
        hospital.add(patient);
        hospital.add(patient2);
        assertTrue(hospital.contains(patient2));
    }

    @Test
    void addContainsPatientTest(){
        Hospital myHospital = new Hospital(2);
        Patient pat1 = new Patient("Günner");
        Patient pat2 = new Patient("Anke");

        myHospital.add(pat1);
        myHospital.add(pat1);
        myHospital.add(pat2);

        assertEquals(2,myHospital.patientCount());
    }

    @Test
    void containsTest() {
        Hospital myHospital = new Hospital(1);
        Patient patient = new Patient("");
        myHospital.add(patient);
        assertTrue(myHospital.contains(patient));
    }

    @Test
    void patientCountTest() {
        Hospital myHospital = new Hospital(20000);
        for (int i = 0; i <= 20000; i++){
            myHospital.add(new Patient("Patient"+i));
        }
        assertEquals(20000,myHospital.patientCount());
    }

    @Test
    void healNextPatientTest() {
        while (hospital.hasPatients()){
            hospital.healNextPatient();
        }
        assertFalse(hospital.hasPatients());
    }

    @Test
    void healNextPatientExceptionTest(){
        hospital.healNextPatient();
        hospital.healNextPatient();
        hospital.healNextPatient();
        Exception exception = assertThrows(HospitalException.class,()->hospital.healNextPatient());
        assertEquals("No patients available.",exception.getMessage());
    }


    @Test
    void hasPatientsTest() {
        assertTrue(hospital.hasPatients());
    }
}