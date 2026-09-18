#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;


// Abstract Class
class DataProcessor
{
public:

    virtual void loadData(string source) = 0;

    virtual void processData() = 0;

    virtual void exportResult(string destination) = 0;

    virtual string processorType() = 0;

    virtual int recordCount() = 0;

    virtual void printSummary()
    {
        cout << "Processor: "
             << processorType() << endl;

        cout << "Records: "
             << recordCount() << endl;
    }

    virtual ~DataProcessor() {}
};


// CSV Processor
class CSVProcessor : public DataProcessor
{
    vector<string> records;

public:

    void loadData(string source) override
    {
        records = {
            "apple,10",
            "banana,20",
            "mango,30",
            "orange,40",
            "grapes,50"
        };
    }

    void processData() override
    {
        for (string& x : records)
        {
            for (char& c : x)
                c = toupper(c);
        }
    }

    void exportResult(string destination) override
    {
        cout << "[CSV EXPORT] " << destination << endl;

        for (string x : records)
            cout << x << endl;
    }

    string processorType() override
    {
        return "CSV Processor";
    }

    int recordCount() override
    {
        return records.size();
    }
};


// Sensor Processor
class SensorStreamProcessor : public DataProcessor
{
    vector<double> readings;

    double mean = 0;
    double minimum = 0;
    double maximum = 0;

public:

    void loadData(string source) override
    {
        readings = {23.4, 21.8, 25.1, 24.6, 22.9};
    }

    void processData() override
    {
        double sum = 0;

        minimum = readings[0];
        maximum = readings[0];

        for (double x : readings)
        {
            sum += x;

            if (x < minimum)
                minimum = x;

            if (x > maximum)
                maximum = x;
        }

        mean = sum / readings.size();
    }

    void exportResult(string destination) override
    {
        cout << "[SENSOR EXPORT] " << destination << endl;

        cout << "Mean: " << mean << endl;
        cout << "Min: " << minimum << endl;
        cout << "Max: " << maximum << endl;
    }

    string processorType() override
    {
        return "Sensor Stream Processor";
    }

    int recordCount() override
    {
        return readings.size();
    }
};


int main()
{
    vector<DataProcessor*> pipeline;

    pipeline.push_back(new CSVProcessor());
    pipeline.push_back(new SensorStreamProcessor());

    for (DataProcessor* p : pipeline)
    {
        p->loadData("source_data");

        p->processData();

        p->printSummary();

        p->exportResult("output_dir");

        cout << "----------------" << endl;
    }

    // DataProcessor dp;
    // ERROR: Cannot create object of abstract class

    for (DataProcessor* p : pipeline)
        delete p;

    return 0;
}