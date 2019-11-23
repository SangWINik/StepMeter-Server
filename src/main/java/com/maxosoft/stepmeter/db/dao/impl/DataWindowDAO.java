package com.maxosoft.stepmeter.db.dao.impl;

import com.maxosoft.stepmeter.db.ConnectionFactory;
import com.maxosoft.stepmeter.db.dao.IDataWindowDAO;
import com.maxosoft.stepmeter.db.model.DataWindow;
import com.maxosoft.stepmeter.db.model.RecordingSession;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DataWindowDAO implements IDataWindowDAO {

    @Override
    public List<DataWindow> getDataWindowsForAccount(Long accountId) {
        List<DataWindow> dataWindows = new ArrayList<>();
        if (accountId == null) {
            return dataWindows;
        }

        try {
            Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM datawindow WHERE sessionId IN(" +
                    "SELECT id FROM recordingsession WHERE accountId=%s AND (deleted IS NULL OR deleted <> '1'))", accountId);
            System.out.println(String.format("Executing query: %s", query));
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                dataWindows.add(this.getFromResultSet(rs));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataWindows;
    }

    @Override
    public List<DataWindow> getDataWindowsExceptAccount(Long accountId) {
        List<DataWindow> dataWindows = new ArrayList<>();
        if (accountId == null) {
            return dataWindows;
        }

        try {
            Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM datawindow WHERE sessionId NOT IN(" +
                    "SELECT id FROM recordingsession WHERE accountId=%s AND (deleted IS NULL OR deleted <> '1'))", accountId);
            System.out.println(String.format("Executing query: %s", query));
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                dataWindows.add(this.getFromResultSet(rs));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataWindows;
    }

    @Override
    public void saveRecordingSession(RecordingSession recordingSession) {
        if (recordingSession == null) {
            return;
        }

        try {
            Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO recordingsession(accountId, deviceId, dateStart, dateEnd) " +
                    "VALUES ('%s', '%s', '%s', '%s')", recordingSession.getAccountId(), recordingSession.getDeviceId(),
                    recordingSession.getDateStart(), recordingSession.getDateEnd());
            System.out.println(String.format("Executing query: %s", query));
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet key = statement.getGeneratedKeys();
            key.next();
            recordingSession.setId(key.getLong(1));
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveDataWindows(List<DataWindow> dataWindows, boolean includeGyroscope) {
        if (dataWindows == null || dataWindows.isEmpty()) {
            return;
        }

        try {
            Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            String fields = "sessionId, accMinX, accMaxX, accMinY, accMaxY, accMinZ, accMaxZ, accMeanX, accMeanY, accMeanZ, " +
                    "accVarX, accVarY, accVarZ, accDevX, accDevY, accDevZ, accSkewX, accSkewY, accSkewZ," +
                    "accKurtX, accKurtY, accKurtZ, accZeroX, accZeroY, accZeroZ";
            if (includeGyroscope) {
                fields += ", gyrMinX, gyrMaxX, gyrMinY, gyrMaxY, gyrMinZ, gyrMaxZ, gyrMeanX, gyrMeanY, gyrMeanZ, " +
                        "gyrVarX, gyrVarY, gyrVarZ, gyrDevX, gyrDevY, gyrDevZ, gyrSkewX, gyrSkewY, gyrSkewZ," +
                        "gyrKurtX, gyrKurtY, gyrKurtZ, gyrZeroX, gyrZeroY, gyrZeroZ";
            }
            List<String> values = new ArrayList<>();
            for (DataWindow dataWindow: dataWindows) {
                values.add(String.format("(%s)", this.getInsertRow(dataWindow, includeGyroscope)));
            }

            String query = String.format("INSERT INTO datawindow(%s) VALUES %s", fields, String.join(",", values));
            System.out.println(String.format("Executing query: %s", query));
            statement.execute(query);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DataWindow getFromResultSet(ResultSet resultSet) throws Exception {
        DataWindow dataWindow = new DataWindow();

        dataWindow.setId(resultSet.getLong("id"));
        dataWindow.setSessionId(resultSet.getLong("sessionId"));

        dataWindow.setAccMinX((float) resultSet.getDouble("accMinX"));
        dataWindow.setAccMaxX((float) resultSet.getDouble("accMaxX"));
        dataWindow.setAccMinY((float) resultSet.getDouble("accMinY"));
        dataWindow.setAccMaxY((float) resultSet.getDouble("accMaxY"));
        dataWindow.setAccMinZ((float) resultSet.getDouble("accMinZ"));
        dataWindow.setAccMaxZ((float) resultSet.getDouble("accMaxZ"));
        dataWindow.setAccMeanX((float) resultSet.getDouble("accMeanX"));
        dataWindow.setAccMeanY((float) resultSet.getDouble("accMeanY"));
        dataWindow.setAccMeanZ((float) resultSet.getDouble("accMeanZ"));
        dataWindow.setAccVarX((float) resultSet.getDouble("accVarX"));
        dataWindow.setAccVarY((float) resultSet.getDouble("accVarY"));
        dataWindow.setAccVarZ((float) resultSet.getDouble("accVarZ"));
        dataWindow.setAccDevX((float) resultSet.getDouble("accDevX"));
        dataWindow.setAccDevY((float) resultSet.getDouble("accDevY"));
        dataWindow.setAccDevZ((float) resultSet.getDouble("accDevZ"));
        dataWindow.setAccSkewX((float) resultSet.getDouble("accSkewX"));
        dataWindow.setAccSkewY((float) resultSet.getDouble("accSkewY"));
        dataWindow.setAccSkewZ((float) resultSet.getDouble("accSkewZ"));
        dataWindow.setAccKurtX((float) resultSet.getDouble("accKurtX"));
        dataWindow.setAccKurtY((float) resultSet.getDouble("accKurtY"));
        dataWindow.setAccKurtZ((float) resultSet.getDouble("accKurtZ"));
        dataWindow.setAccZeroX((float) resultSet.getDouble("accZeroX"));
        dataWindow.setAccZeroY((float) resultSet.getDouble("accZeroY"));
        dataWindow.setAccZeroZ((float) resultSet.getDouble("accZeroZ"));

        dataWindow.setGyrMinX((float) resultSet.getDouble("gyrMinX"));
        dataWindow.setGyrMaxX((float) resultSet.getDouble("gyrMaxX"));
        dataWindow.setGyrMinY((float) resultSet.getDouble("gyrMinY"));
        dataWindow.setGyrMaxY((float) resultSet.getDouble("gyrMaxY"));
        dataWindow.setGyrMinZ((float) resultSet.getDouble("gyrMinZ"));
        dataWindow.setGyrMaxZ((float) resultSet.getDouble("gyrMaxZ"));
        dataWindow.setGyrMeanX((float) resultSet.getDouble("gyrMeanX"));
        dataWindow.setGyrMeanY((float) resultSet.getDouble("gyrMeanY"));
        dataWindow.setGyrMeanZ((float) resultSet.getDouble("gyrMeanZ"));
        dataWindow.setGyrVarX((float) resultSet.getDouble("gyrVarX"));
        dataWindow.setGyrVarY((float) resultSet.getDouble("gyrVarY"));
        dataWindow.setGyrVarZ((float) resultSet.getDouble("gyrVarZ"));
        dataWindow.setGyrDevX((float) resultSet.getDouble("gyrDevX"));
        dataWindow.setGyrDevY((float) resultSet.getDouble("gyrDevY"));
        dataWindow.setGyrDevZ((float) resultSet.getDouble("gyrDevZ"));
        dataWindow.setGyrSkewX((float) resultSet.getDouble("gyrSkewX"));
        dataWindow.setGyrSkewY((float) resultSet.getDouble("gyrSkewY"));
        dataWindow.setGyrSkewZ((float) resultSet.getDouble("gyrSkewZ"));
        dataWindow.setGyrKurtX((float) resultSet.getDouble("gyrKurtX"));
        dataWindow.setGyrKurtY((float) resultSet.getDouble("gyrKurtY"));
        dataWindow.setGyrKurtZ((float) resultSet.getDouble("gyrKurtZ"));
        dataWindow.setGyrZeroX((float) resultSet.getDouble("gyrZeroX"));
        dataWindow.setGyrZeroY((float) resultSet.getDouble("gyrZeroY"));
        dataWindow.setGyrZeroZ((float) resultSet.getDouble("gyrZeroZ"));

        return dataWindow;
    }

    private String getInsertRow(DataWindow dataWindow, boolean includeGyroscope) {
        String values = String.format("'%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s'," +
                        "'%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s'",
                dataWindow.getSessionId(), dataWindow.getAccMinX(), dataWindow.getAccMaxX(),
                dataWindow.getAccMinY(), dataWindow.getAccMaxY(), dataWindow.getAccMinZ(), dataWindow.getAccMaxZ(),
                dataWindow.getAccMeanX(), dataWindow.getAccMeanY(), dataWindow.getAccMeanZ(),
                dataWindow.getAccVarX(), dataWindow.getAccVarY(), dataWindow.getAccVarZ(),
                dataWindow.getAccDevX(), dataWindow.getAccDevY(), dataWindow.getAccDevZ(),
                dataWindow.getAccSkewX(), dataWindow.getAccSkewY(), dataWindow.getAccSkewZ(),
                dataWindow.getAccKurtX(), dataWindow.getAccKurtY(), dataWindow.getAccKurtZ(),
                dataWindow.getAccZeroX(), dataWindow.getAccZeroY(), dataWindow.getAccZeroZ());
        if (includeGyroscope) {
            values += String.format(", '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s'," +
                            "'%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s'",
                    dataWindow.getGyrMinX(), dataWindow.getGyrMaxX(),
                    dataWindow.getGyrMinY(), dataWindow.getGyrMaxY(), dataWindow.getGyrMinZ(), dataWindow.getGyrMaxZ(),
                    dataWindow.getGyrMeanX(), dataWindow.getGyrMeanY(), dataWindow.getGyrMeanZ(),
                    dataWindow.getGyrVarX(), dataWindow.getGyrVarY(), dataWindow.getGyrVarZ(),
                    dataWindow.getGyrDevX(), dataWindow.getGyrDevY(), dataWindow.getGyrDevZ(),
                    dataWindow.getGyrSkewX(), dataWindow.getGyrSkewY(), dataWindow.getGyrSkewZ(),
                    dataWindow.getGyrKurtX(), dataWindow.getGyrKurtY(), dataWindow.getGyrKurtZ(),
                    dataWindow.getGyrZeroX(), dataWindow.getGyrZeroY(), dataWindow.getGyrZeroZ());
        }

        return values;
    }
}
