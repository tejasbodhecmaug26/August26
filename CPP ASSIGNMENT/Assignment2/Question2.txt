#include <iostream>
#include <string>
using namespace std;

class Patient
{
private:
    int patientId;
    string name;
    int age;
    string ward;
    const string bloodGroup;

public:

    Patient()
        : patientId(0),
          name("Unknown"),
          age(0),
          ward("General"),
          bloodGroup("O+")
    {
        cout << "Default constructor called" << endl;
    }

  
    Patient(int id, const string& name)
        : patientId(id),
          name(name),
          age(0),
          ward("General"),
          bloodGroup("O+")
    {
        cout << "Emergency constructor called" << endl;
    }


    Patient(int id, const string& name, int age,
            const string& ward, const string& bg)
        : patientId(id),
          name(name),
          age(age),
          ward(ward),
          bloodGroup(bg)
    {
        cout << "Full admission constructor called" << endl;
    }

    ~Patient()
    {
        cout << "Patient " << name << " discharged." << endl;
    }

   
    void displayRecord() const
    {
        cout << "ID: " << patientId
             << ", Name: " << name
             << ", Age: " << age
             << ", Ward: " << ward
             << ", Blood Group: " << bloodGroup
             << endl;
    }

    void transferWard(const string& newWard)
    {
        ward = newWard;
    }
};

int main()
{
  
    Patient p1;
    Patient p2(101, "Rahul");
    Patient p3(102, "Amit", 35, "ICU", "B+");

    cout << "\n--- Stack Patients ---" << endl;

    p1.displayRecord();
    p2.displayRecord();
    p3.displayRecord();



    cout << "\n--- Dynamic Array ---" << endl;

    Patient* patients = new Patient[4];



    cout << "\nPatients in Dynamic Array:" << endl;

    for (int i = 0; i < 4; i++)
    {
        patients[i].displayRecord();
    }


    cout << "\n--- Transferring Patient ---" << endl;

    patients[1].transferWard("ICU");

    patients[1].displayRecord();


  
    cout << "\n--- Deleting Dynamic Array ---" << endl;

    delete[] patients;


    cout << "\n--- End of main ---" << endl;

    return 0;
}