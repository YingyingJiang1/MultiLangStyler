#include <iostream>
#include <vector>
#include <string>
#include <functional>

class Task {
 public:
  Task(const std::string& name, std::function<void()> fn)
      : name_(name), fn_(fn) {}

  void Run() const {
    std::cout << "[Run] " << name_ << std::endl;
    fn_();
  }

 private:
  std::string name_;
  std::function<void()> fn_;
};

class TaskScheduler {
 public:
  void AddTask(const Task& t) {
    tasks_.push_back(t);
  }

  void RunAll() {
    for (const auto& t : tasks_) {
      t.Run();
    }
  }

 private:
  std::vector<Task> tasks_;
};

int main() {
  TaskScheduler scheduler;

  scheduler.AddTask(Task("Compute", []() {
    int sum = 0;
    for (int i = 0; i < 100; ++i) {
      sum += i;
    }
    std::cout << "Sum = " << sum << std::endl;
  }));

  scheduler.AddTask(Task("Message", []() {
    std::cout << "Hello from task." << std::endl;
  }));

  scheduler.RunAll();

  return 0;
}
