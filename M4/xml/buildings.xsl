<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">
        <html lang="es">
            <head>
                <meta charset="UTF-8"/>
                <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
                <title>Edificios</title>
                <link rel="stylesheet" href="buildings.css"/>
            </head>
            <body>
                <header role="banner">
                    <nav role="navigation">
                        <div class="menu-toggle" aria-label="Toggle menu" aria-expanded="false" onclick="toggleMenu()">☰</div>
                        <ul id="menu">
                            <li><a href="index.html">Índice</a></li>
                            <li><a href="attack_units.html">Unidades de Ataque</a></li>
                            <li><a href="buildings.html" aria-current="page">Edificios</a></li>
                            <li><a href="defences.html">Defensas</a></li>
                            <li><a href="special_units.html">Unidades Especiales</a></li>
                        </ul>
                    </nav>
                </header>
                <main role="main">
                    <section id="buildings" aria-labelledby="buildings-title">
                        <h1 id="buildings-title">Edificios</h1>
                        <xsl:apply-templates select="buildings/building"/>
                    </section>
                </main>
                <footer role="contentinfo">
                    <p>2024 Civilizations. Todos los derechos reservados.</p>
                    <p><a href="https://github.com/MarcArques" target="_blank">Marc Arqués Marimón</a></p>
                    <p><a href="https://github.com/AdrianCasadoAguilera" target="_blank">Adrián Casado Aguilera</a></p>
                    <p><a href="https://github.com/AAyoubelbakhti" target="_blank">Ayoub El Bakhti</a></p>
                    <p><a href="https://github.com/OscarMG018" target="_blank">Óscar MG018</a></p>
                </footer>
                <script src="minimenu.js"></script>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="building">
        <article class="building-section">
            <xsl:attribute name="id">
                <xsl:value-of select="translate(name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')"/>
            </xsl:attribute>
            <h2><xsl:value-of select="name"/></h2>
            <div class="table-container">
                <table>
                    <caption>Estadísticas de <xsl:value-of select="name"/></caption>
                    <thead>
                        <tr>
                            <th scope="col">Food Cost</th>
                            <th scope="col">Iron Cost</th>
                            <th scope="col">Wood Cost</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><xsl:value-of select="costs/food_cost"/></td>
                            <td><xsl:value-of select="costs/iron_cost"/></td>
                            <td><xsl:value-of select="costs/wood_cost"/></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="building">
                <img>
                    <xsl:attribute name="src">
                        <xsl:value-of select="concat('images/', translate(name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '.png')"/>
                    </xsl:attribute>
                    <xsl:attribute name="alt">
                        <xsl:value-of select="concat('Imagen de ', name)"/>
                    </xsl:attribute>
                </img>
                <p><xsl:value-of select="description"/></p>
            </div>
        </article>
    </xsl:template>
</xsl:stylesheet>
