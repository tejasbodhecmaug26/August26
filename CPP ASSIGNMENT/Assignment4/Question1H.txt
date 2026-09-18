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

    // == operator
    bool operator==(const LedgerEntry& other) const
    {
        double sum1 = 0;
        double sum2 = 0;

        for (int i = 0; i < days; i++)
            sum1 += amounts[i];

        for (int i = 0; i < other.days; i++)
            sum2 += other.amounts[i];

        return sum1 == sum2;
    }

    // > operator
    bool operator>(const LedgerEntry& other) const
    {
        double sum1 = 0;
        double sum2 = 0;

        for (int i = 0; i < days; i++)
            sum1 += amounts[i];

        for (int i = 0; i < other.days; i++)
            sum2 += other.amounts[i];

        return sum1 > sum2;
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

    feb[0] = 100;
    feb[1] = 200;
    feb[2] = 300;

    cout << "Jan == Feb: ";

    if (jan == feb)
        cout << "Yes";
    else
        cout << "No";

    cout << endl;

    cout << "Jan > Feb: ";

    if (jan > feb)
        cout << "Yes";
    else
        cout << "No";

    return 0;
}