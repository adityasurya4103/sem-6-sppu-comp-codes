<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>XML-14K15A0501</title>
            </head>
            <body>
            <style>
                table {
                    border-collapse: collapse;
                    width: 100%;
                }
                th {
                    font-size: 18px;
                    color: blue;
                    border: 1px solid black;
                    padding: 8px;
                    text-align: left;
                }
                tr:nth-child(even) {
                    background-color: #f2f2f2;
                }
                th:hover{
                    background-color: black;
                    color:white;
                }
                tr:hover {
                    background-color: black;
                    color:white;
                }
                td {
                    border: 1px solid black;
                    padding: 8px;
                    vertical-align: top;
                }
                td.salary {
                    text-align: right;
                }
            </style>

                <table>
                    <tr>
                        <th>Username</th>
                        <th>Password</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Gender</th>
                        <th>Email</th>
                        <th>Position</th>
                        <th>Salary</th>
                        <th>Contact</th>
                    </tr>
                    <xsl:for-each select="company/employee">
                        <tr>
                            <td>
                                <xsl:value-of select="username" />
                            </td>
                            <td>
                                <xsl:value-of select="password" />
                            </td>
                            <td>
                                <xsl:value-of select="firstname" />
                            </td>
                            <td>
                                <xsl:value-of select="lastname" />
                            </td>
                            <td>
                                <xsl:value-of select="gender" />
                            </td>
                            <td>
                                <xsl:value-of select="email" />
                            </td>
                            <td>
                                <xsl:value-of select="position" />
                            </td>
                            <td class="salary">
                                ₹<xsl:value-of select="salary"/>
                            </td>
                            <td>
                                <xsl:value-of select="contact" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>

            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
