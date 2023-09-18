package com.sonhlt.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    //tạo list để lưu trữ dữ liệu staff
    static List<Staff> staffList = new ArrayList<>();
    //khởi tạo dữ liệu cho list
    static {
        staffList.add(new Staff(1, "Son", "IT", 100));
        staffList.add(new Staff(2, "Hoang", "Accounting", 400));
        staffList.add(new Staff(3, "Le", "Station", 250));
        staffList.add(new Staff(4, "Thanh", "BOD", 700));
        //new line
        staffList.add(new Staff(5, "Son", "BOD", 700));
    }

    @GetMapping()
    public List<Staff> getAllStaffs() {
        return staffList;
    }

    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable  int id) {
        return this.getStaff(id);
    }

    private Staff getStaff(int id) {
        for (Staff staff : staffList) {
            if (staff.getId() == id) {
                return staff;
            }
        }
        //Không nên return null
        return null;
    }

    @PostMapping()
    public List<Staff> addStaff(@RequestBody Staff staff) {
        staffList.add(staff);
        return staffList;
    }

    @PutMapping("/{id}")
    public List<Staff> updateStaff(@PathVariable int id, @RequestBody Staff staff) {
        staffList.remove(getStaff(id));
        staff.setId(id);
        staffList.add(staff);
        return staffList;
    }

    @DeleteMapping("/{id}")
    public List<Staff> deleteStaff(@PathVariable int id) {
        staffList.remove(getStaff(id));
        return staffList;
    }
}
