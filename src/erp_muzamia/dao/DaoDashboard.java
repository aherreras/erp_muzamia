/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import java.util.List;

/**
 *
 * @author User
 */
public interface DaoDashboard {
    
    public List<Object[]> listarDashboard();
    
    public List<Object[]> listarDashboard(List<Integer> ids);
    
    public List<Object[]> listarDashboardCl();
    
    public List<Object[]> listarDashboardPr();
    
    public List<Object[]> listarDashboardSv();
    
    public List<Object[]> listarDashboardSv(String ini, String fin);
    
    public List<Object[]> listarDashboardSv(List<Integer> ids);
    
    public List<Object[]> listarDashboardMt();
    
    public List<Object[]> listarDashboardMt(String ini, String fin);
    
    public List<Object[]> listarDashboardMt(List<Integer> ids);
    
    public List<Object[]> getCajaId();
    
}
