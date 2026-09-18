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
    }

    // + operator
    LedgerEntry operator+(const LedgerEntry& other) const
    {
        LedgerEntry result("Combined", days);

        for (int i = 0; i < days; i++)
        {
            result.amounts[i] =
                amounts[i] + other.amounts[i];
        }

        return result;
    }

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
    LedgerEntry jan("January", 3);
    LedgerEntry feb("February", 3);

    jan[0] = 100;
    jan[1] = 200;
    jan[2] = 300;

    feb[0] = 10;
    feb[1] = 20;
    feb[2] = 30;

    LedgerEntry combined = jan + feb;

    cout << combined[0] << endl;
    cout << combined[1] << endl;
    cout << combined[2] << endl;

    return 0;
}