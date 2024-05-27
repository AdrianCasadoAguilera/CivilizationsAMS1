from lxml import etree
import os

# Función para leer el XML
def read_xml(path):
    with open(path, 'r', encoding='utf-8') as file:
        string = file.read()
    return bytes(bytearray(string, encoding='utf-8'))

# Función para escribir en el HTML
def write_html(path, html):
    with open(path, 'w', encoding='utf-8') as file:
        file.write(html)

# Función para transformar XML a HTML
def transform_xml_to_html(xml_path, xsl_path, output_path, **params):
    xml = read_xml(xml_path)
    xml_tree = etree.XML(xml)
    xsl = read_xml(xsl_path)
    xsl_tree = etree.XML(xsl)
    transform = etree.XSLT(xsl_tree)
    html_dom = transform(xml_tree, **params)
    html_result = etree.tostring(html_dom, pretty_print=True).decode('utf-8')
    write_html(output_path, html_result)

if __name__ == "__main__":
    xml_path1 = './xml/attack_units.xml'
    xsl_path1 = './xml/attack_units.xsl'
    output_path1 = './html/attack_units.html'
    xml_path2 = './xml/buildings.xml'
    xsl_path2 = './xml/buildings.xsl'
    output_path2 = './html/buildings.html'
    xml_path3 = './xml/defences.xml'
    xsl_path3 = './xml/defences.xsl'
    output_path3 = './html/defences.html'
    xml_path4 = './xml/special_units.xml'
    xsl_path4 = './xml/special_units.xsl'
    output_path4 = './html/special_units.html'
    xml_path5 = './xml/civilizations.xml'
    xsl_path5 = './xml/civilizations.xsl'
    output_path5 = './html/civilizations.html'
    transform_xml_to_html(xml_path1, xsl_path1, output_path1)
    transform_xml_to_html(xml_path2, xsl_path2, output_path2)
    transform_xml_to_html(xml_path3, xsl_path3, output_path3)
    transform_xml_to_html(xml_path4, xsl_path4, output_path4)
    transform_xml_to_html(xml_path5, xsl_path5, output_path5)