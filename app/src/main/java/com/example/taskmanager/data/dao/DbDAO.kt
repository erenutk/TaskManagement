package com.example.taskmanager.data.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.taskmanager.data.entities.CTO
import com.example.taskmanager.data.entities.CTOWithDepartments
import com.example.taskmanager.data.entities.Department
import com.example.taskmanager.data.entities.DepartmentManager
import com.example.taskmanager.data.entities.DepartmentManagerWithStaff
import com.example.taskmanager.data.entities.DepartmentWithDetails
import com.example.taskmanager.data.entities.Staff
import com.example.taskmanager.data.entities.Task
import com.example.taskmanager.data.entities.TaskStaffCrossRef
import com.example.taskmanager.data.entities.TaskWithStaff


@Dao
interface DbDAO {
    // CTO methods
    @Insert
    suspend fun insertCTO(cto: CTO)

    @Query("SELECT * FROM CTO WHERE id = :ctoId")
    suspend fun getCTOById(ctoId: Int): CTO

    @Transaction
    @Query("SELECT * FROM CTO WHERE id = :ctoId")
    suspend fun getCTOWithDepartments(ctoId: Int): List<CTOWithDepartments>

    // Department methods
    @Insert
    suspend fun insertDepartment(department: Department)

    @Transaction
    @Query("SELECT * FROM Department WHERE id = :departmentId")
    suspend fun getDepartmentWithDetails(departmentId: Int): List<DepartmentWithDetails>

    // Department Manager methods
    @Insert
    suspend fun insertDepartmentManager(manager: DepartmentManager)

    @Transaction
    @Query("SELECT * FROM DepartmentManager WHERE id = :managerId")
    suspend fun getDepartmentManagerWithStaff(managerId: Int): List<DepartmentManagerWithStaff>

    // Staff methods
    @Insert
    suspend fun insertStaff(staff: Staff)

    @Query("SELECT * FROM Staff WHERE id = :staffId")
    suspend fun getStaffById(staffId: Int): Staff

    // Task methods
    @Insert
    suspend fun insertTask(task: Task)

    @Insert
    suspend fun insertTaskStaffCrossRef(crossRef: TaskStaffCrossRef)

    @Transaction
    @Query("SELECT * FROM TaskStaffCrossRef WHERE staffId = :staffId") // Get all tasks assigned to a staff
    suspend fun getTaskFromStaff(staffId: Int): List<TaskWithStaff>


    @Transaction
    @Query("SELECT * FROM TaskStaffCrossRef WHERE taskId = :taskId") // Get all staff assigned to a task
    abstract fun getStaffFromTask(taskId: Int): List<TaskWithStaff>




    // Update methods if needed
    @Update
    suspend fun updateCTO(cto: CTO)

    @Update
    suspend fun updateDepartment(department: Department)

    @Update
    suspend fun updateDepartmentManager(manager: DepartmentManager)

    @Update
    suspend fun updateStaff(staff: Staff)

    @Update
    suspend fun updateTask(task: Task)

}
