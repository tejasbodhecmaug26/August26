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

    // Friend functions
    friend ostream& operator<<(
        ostream& out,
        const LedgerEntry& entry);

    friend istream& operator>>(
        istream& in,
        LedgerEntry& entry);

    ~LedgerEntry()
    {
        delete[] amounts;
    }
};


// << operator
ostream& operator<<(
    ostream& out,
    const LedgerEntry& entry)
{
    double total = 0;

    out << entry.description << " : [";

    for (int i = 0; i < entry.days; i++)
    {
        out << entry.amounts[i];

        if (i < entry.days - 1)
            out << ", ";

        total += entry.amounts[i];
    }

    out << "] Total: " << total;

    return out;
}


// >> operator
istream& operator>>(
    istream& in,
    LedgerEntry& entry)
{
    for (int i = 0; i < entry.days; i++)
    {
        in >> entry.amounts[i];
    }

    return in;
}


int main()
{
    LedgerEntry jan("January Sales", 5);

    cout << "Enter 5 amounts: ";

    cin >> jan;

    cout << jan << endl;

    return 0;
}