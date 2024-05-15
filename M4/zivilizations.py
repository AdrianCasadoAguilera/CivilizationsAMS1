from lxml import etree
import os

def read_xml(path):
    with open(path, 'r', encoding='utf-8') as file:
        string = file.read()
    return bytes(bytearray(string, encoding='utf-8'))

def write_html(path, html):
    with open(path, 'w', encoding='utf-8') as file:
        file.write(html)

def transform_xml_to_html(xml_path, xsl_path, output_path, **params):
    xml = read_xml(xml_path)
    xml_tree = etree.XML(xml)
    xsl = read_xml(xsl_path)
    xsl_tree = etree.XML(xsl)
    transform = etree.XSLT(xsl_tree)
    html_dom = transform(xml_tree, **params)
    html_result = etree.tostring(html_dom, pretty_print=True).decode('utf-8')
        write_html(output_path, html_result)
