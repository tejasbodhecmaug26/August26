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

    // Normal constructor
    LedgerEntry(const string& desc, int d)
    {
        description = desc;
        days = d;

        amounts = new double[days];

        for (int i = 0; i < days; i++)
            amounts[i] = 0;
    }

    // Copy Constructor
    LedgerEntry(const LedgerEntry& other)
    {
        description = other.description;
        days = other.days;

        amounts = new double[days];

        for (int i = 0; i < days; i++)
            amounts[i] = other.amounts[i];

        cout << "Copy Constructor Called" << endl;
    }

    // [] operator
    double& operator[](int index)
    {
        return amounts[index];
    }

    ~LedgerEntry()
    {
        delete[] amounts;
    }
};

int main()
{
    LedgerEntry jan("January Sales", 3);

    jan[0] = 100;
    jan[1] = 200;
    jan[2] = 300;

    LedgerEntry copy = jan;

    cout << "Original: " << jan[0] << endl;
    cout << "Copy: " << copy[0] << endl;

    return 0;
}