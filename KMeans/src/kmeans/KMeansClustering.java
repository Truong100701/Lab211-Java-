/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package kmeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class for performing K-means clustering algorithm on a list of students.
 */
public class KMeansClustering {

    private List<Student> students;
    private List<List<Student>> clusters;

    /**
     * Constructs a KMeansClustering object with the given list of students.
     *
     * @param students the list of students to be clustered
     */
    public KMeansClustering(List<Student> students) {
        this.students = students;
        this.clusters = new ArrayList<>();
    }

    /**
     * Runs the K-means clustering algorithm with the specified number of
     * clusters (k).
     *
     * @param k the number of clusters
     */
    public void runProcessKmean(int k) {
        Random random = new Random();
        List<Student> centroids = new ArrayList<>();

//        for (int i = 0; i < k; i++) {
//            int randomCentroids = random.nextInt(students.size());
//                centroids.add(students.get(randomCentroids));
//        }
        for (int i = 0; i < k; i++) {
            int randomCentroidIndex = random.nextInt(students.size());
            Student randomCentroid = students.get(randomCentroidIndex);

            while (centroids.contains(randomCentroid)) {
                randomCentroidIndex = random.nextInt(students.size());
                randomCentroid = students.get(randomCentroidIndex);
            }
            centroids.add(randomCentroid);
        }

        boolean isConverged = false;

        while (!isConverged) {
            List<List<Student>> newClusters = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                newClusters.add(new ArrayList<>());
            }

            for (Student student : students) {
                int closestCentroidIndex = findClosestCentroidIndex(student, centroids);
                newClusters.get(closestCentroidIndex).add(student);
            }

            List<Student> newCentroids = calculateCentroids(newClusters);

            isConverged = true;

            for (int i = 0; i < k; i++) {
                double distance = calculateEuclideanDistance(centroids.get(i), newCentroids.get(i));
                if (distance > 0) {
                    isConverged = false;
                    break;
                }
            }

            if (isConverged) {
                break;
            } else {
                centroids = newCentroids;
                clusters = newClusters;
            }
        }
    }

    /**
     * Calculates the centroids for each cluster based on the students in each
     * cluster.
     *
     * @param clusters the list of clusters
     * @return the list of centroids
     */
    public List<Student> calculateCentroids(List<List<Student>> clusters) {
        List<Student> centroids = new ArrayList<>();

        for (List<Student> cluster : clusters) {
            double sumLoc = 0.0;
            double sumMad = 0.0;
            double sumPro = 0.0;
            double sumPrf = 0.0;
            double sumCsi = 0.0;

            for (Student student : cluster) {
                sumLoc += student.getLoc();
                sumMad += student.getMad();
                sumPro += student.getPro();
                sumPrf += student.getPrf();
                sumCsi += student.getCsi();
            }

            double centroidLoc = sumLoc / cluster.size();
            double centroidMad = sumMad / cluster.size();
            double centroidPro = sumPro / cluster.size();
            double centroidPrf = sumPrf / cluster.size();
            double centroidCsi = sumCsi / cluster.size();

            centroids.add(new Student("", "", centroidLoc, centroidMad, centroidPro, centroidPrf, centroidCsi));
        }

        return centroids;
    }

    /**
     * Finds the index of the closest centroid to the given student.
     *
     * @param student the student
     * @param centroids the list of centroids
     * @return the index of the closest centroid
     */
    private int findClosestCentroidIndex(Student student, List<Student> centroids) {
        double minDistance = Double.MAX_VALUE;
        int closestIndex = -1;

        for (int i = 0; i < centroids.size(); i++) {
            double distance = calculateEuclideanDistance(student, centroids.get(i));
            if (distance < minDistance) {
                minDistance = distance;
                closestIndex = i;
            }
        }

        return closestIndex;
    }

    /**
     * Calculates the Euclidean distance between two students based on their
     * features.
     *
     * @param student1 the first student
     * @param student2 the second student
     * @return the Euclidean distance between the two students
     */
    private double calculateEuclideanDistance(Student student1, Student student2) {
        double locDiff = student1.getLoc() - student2.getLoc();
        double madDiff = student1.getMad() - student2.getMad();
        double proDiff = student1.getPro() - student2.getPro();
        double prfDiff = student1.getPrf() - student2.getPrf();
        double csiDiff = student1.getCsi() - student2.getCsi();

        return Math.sqrt(locDiff * locDiff + madDiff * madDiff + proDiff * proDiff + prfDiff * prfDiff + csiDiff * csiDiff);
    }

    /**
     * Returns the clusters generated by the K-means clustering algorithm.
     *
     * @return the clusters
     */
    public List<List<Student>> getClusters() {
        return clusters;
    }

}
