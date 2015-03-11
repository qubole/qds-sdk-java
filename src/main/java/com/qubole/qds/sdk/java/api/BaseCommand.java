package com.qubole.qds.sdk.java.api;

/**
 * This class is base command for various commands, it has basic information only and primary purpose
 * is to use it in composite command
 */
public interface BaseCommand
{
    public enum COMMAND_TYPE
    {
        NONE,
        HIVE,
        HADOOP,
        PRESTO,
        DB_QUERY,
        DB_EXPORT,
        DB_IMPORT,
        PIG,
        SHELL
    };

    public COMMAND_TYPE getCommandType();

    public String getJSONString();
}
