#include <iostream>
using namespace std;

int main()
{
    int N;

    
    cout << "Enter number of readings: ";
    cin >> N;

    double temp[100];

    for (int i = 0; i < N; i++)
    {
        cin >> temp[i];
    }
    int errors = 0;

    cout << "Valid readings: ";

    for (int i = 0; i < N; i++)
    {
        if (temp[i] < 0)
        {
            errors++;
            continue;
        }

        cout << temp[i] << " ";
    }

    cout << endl;
    cout << "Skipped (errors): " << errors << endl;

    
    for (int i = 0; i < N; i++)
    {
        if (temp[i] >= 45)
        {
            cout << "First CRITICAL : Index " << i
                 << " -> " << temp[i] << "°C" << endl;
            break;
        }
    }


    double min = 0, max = 0, sum = 0;
    int count = 0;

    for (int i = 0; i < N; i++)
    {
        if (temp[i] < 0)
            continue;

        if (count == 0)
        {
            min = temp[i];
            max = temp[i];
        }

        if (temp[i] < min)
            min = temp[i];

        if (temp[i] > max)
            max = temp[i];

        sum = sum + temp[i];
        count++;
    }

    double avg = sum / count;

    cout << "Min : " << min << "°C"
         << "    Max : " << max << "°C"
         << "    Avg : " << avg << "°C" << endl;


    int normal = 0, warning = 0, critical = 0, shutdown = 0;

    for (int i = 0; i < N; i++)
    {
        if (temp[i] < 0)
            continue;

        if (temp[i] <= 29)
            normal++;
        else if (temp[i] <= 44)
            warning++;
        else if (temp[i] <= 59)
            critical++;
        else
            shutdown++;
    }

    cout << "Normal: " << normal << "  ";
    cout << "Warning: " << warning << "  ";
    cout << "Critical: " << critical << "  ";
    cout << "Shutdown: " << shutdown << endl;

    return 0;
}