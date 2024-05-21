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
    xml_path = '/xml/database.xml'
    xsl_path = '/xml/database.xsl'
    output_path = '/html/recursos.html'
    transform_xml_to_html(xml_path, xsl_path, output_path)
