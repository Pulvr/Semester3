package higherorderfunctionstest.hospital;

import java.util.LinkedList;
import java.util.function.Consumer;

class Hospital {
    LinkedList<Patient> patients = new LinkedList<>();

    void add(Patient patient) {
        patients.addLast(patient);
    }

    public static void main(String[] args) {
        var hospital = new Hospital();
        hospital.add(new Patient(1, 3));
        hospital.add(new Patient(2, 5));
        hospital.add(new Patient(3, 6));
        hospital.forEach(patient -> System.out.println(patient.roomNumber()));
    }

    //die Action ist das lambda von darüber
    void forEach(Consumer<Patient> action) {
        for (Patient patient : patients) {
            //lazy eval
            action.accept(patient);
        }
    }
}