#include <iostream>
#include <string>
using namespace std;

class LedgerEntry
{
private:
    string description;
    double* amounts;
    int days;

public:

    LedgerEntry(const string& desc, int d)
    {
        description = desc;
        days = d;

        amounts = new double[days];

        for (int i = 0; i < days; i++)
            amounts[i] = 0;

        cout << "Constructor: " << description << endl;
    }

    ~LedgerEntry()
    {
        delete[] amounts;

        cout << "Destructor: "
             << description << endl;
    }
};

int main()
{
    LedgerEntry jan("January", 5);

    {
        LedgerEntry feb("February", 5);
    }

    cout << "End of main" << endl;

    return 0;
}