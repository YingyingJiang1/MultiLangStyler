#include <iostream>
#include <vector>
#include <string>
#include <functional>

class Task
{
public:
    Task(const std::string &name, std::function<void()> fn)
        : name_(name), fn_(fn)
    {
    }

    void run() const
    {
        std::cout << "[Run] " << name_ << std::endl;
        fn_();
    }

private:
    std::string name_;
    std::function<void()> fn_;
};

class TaskScheduler
{
public:
    void addTask(const Task &t)
    {
        tasks_.push_back(t);
    }

    void runAll()
    {
        for (const auto &t : tasks_)
        {
            t.run();
        }
    }

private:
    std::vector<Task> tasks_;
};

int main()
{
    TaskScheduler scheduler;

    scheduler.addTask(Task("Compute", []()
    {
        int sum = 0;

        for (int i = 0; i < 100; ++i)
        {
            sum += i;
        }

        std::cout << "Sum = " << sum << std::endl;
    }));

    scheduler.addTask(Task("Message", []()
    {
        std::cout << "Hello from task." << std::endl;
    }));

    scheduler.runAll();

    return 0;
}
