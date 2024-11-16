package com.edubridge.app3.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.edubridge.app3.model.Doctor;
import com.edubridge.app3.utils.HibernateUtils;

public class DoctorDao implements DoctorDaoI {

	@Override
	public void addDoctor(Doctor doctor) {
		Transaction tx = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			session.persist(doctor);
			tx = session.beginTransaction();
			tx.commit();
			System.out.println("new doctor addedd!");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = new ArrayList<Doctor>();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {

			String hql = "from Doctor";
			Query query = session.createQuery(hql, Doctor.class);
			doctors = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctors;
	}

	@Override
	public Doctor getDoctorById(Integer id) {
		Doctor doctor = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			doctor = session.get(Doctor.class, id);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return doctor;
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		Transaction tx = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			session.merge(doctor);
			tx = session.beginTransaction();
			tx.commit();
			System.out.println("doctor is updated!");

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDoctor(Integer id) {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();

			Doctor doctor = session.get(Doctor.class, id);

			if (doctor != null) {
				session.remove(doctor);
				tx.commit();
				System.out.println("Doctor is deleted!");
			} else {
				System.out.println("no doctor found!");
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAllDoctors() {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			String hql = "delete from Doctor";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			System.out.println("All doctors are deleted");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
